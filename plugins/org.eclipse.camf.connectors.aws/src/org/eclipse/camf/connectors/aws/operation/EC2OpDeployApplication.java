/*******************************************************************************
 * Copyright (c) 2014 Laboratory for Internet Computing, University of Cyprus.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the 
 * CELAR project founded by European Union
 * project number: FP7-317790  http://www.celarcloud.eu
 *
 * Contributors:
 *  Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.connectors.aws.operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import org.eclipse.camf.connectors.aws.EC2Client;
import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TServiceTemplate;
import org.eclipse.camf.tosca.TTopologyTemplate;
import org.eclipse.camf.tosca.core.TOSCAModel;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.jclouds.ec2.domain.InstanceType;
import org.jclouds.ec2.features.InstanceApi;
import org.jclouds.ec2.options.RunInstancesOptions;

import com.google.common.base.Optional;



/**
 * @author Nicholas Loulloudes
 *
 */
public class EC2OpDeployApplication extends AbstractEC2OpDeployApplication {
  
  private final EC2Client ec2;
  private TOSCAResource toscaResource = null;
  private ICloudProject project = null;
  private TOSCAModel toscaModel = null; 
  
  
  public EC2OpDeployApplication(final EC2Client ec2, final ICloudApplicationDescription description ) {
    this.ec2 = ec2;    
    if( description instanceof TOSCAResource ) {
      this.toscaResource = ( TOSCAResource ) description;
      this.toscaModel = this.toscaResource.getTOSCAModel();
    } else if (description instanceof TOSCAModel) {
      this.toscaModel = (TOSCAModel) description;      
    } else {
      this.toscaResource = null;
      this.toscaModel = null;
    }
//    this.project = this.toscaResource.getProject();
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.connectors.aws.operation.AbstractEC2OpDeployApplication#run()
   */
  @Override
  public void run() {
    setResult( null );
    setException( null );
    
    if (this.toscaModel == null){
      return;
    }

    TServiceTemplate serviceTemplate = toscaModel.getServiceTemplate();
    if( serviceTemplate != null ) {
      TTopologyTemplate topologyTemplate = serviceTemplate.getTopologyTemplate();
      if( topologyTemplate != null ) {
        EList<TNodeTemplate> nodeTemplateList = topologyTemplate.getNodeTemplate();
        if( nodeTemplateList != null ) {
          // Instantiate each node in the topology
          for( TNodeTemplate node : nodeTemplateList ) {
            int minCount = node.getMinInstances();
            int maxCount = ( ( BigInteger )node.getMaxInstances() ).intValue();
            // Get Deployment Artifacts
            TDeploymentArtifacts deploymentArtifacts = node.getDeploymentArtifacts();
            String amiID = null;
            String keypair = null;
            String keypairName = null;
            for( TDeploymentArtifact artifact : deploymentArtifacts.getDeploymentArtifact() )
            {
              // Find the VMI or Keypair artifacts
              String artifactType = artifact.getArtifactType().toString();
              if( artifactType.equals( "VMI" ) ) { //$NON-NLS-1$
                amiID = artifact.getName();
              } else if( artifactType.equals( "KeyPair" ) ) { //$NON-NLS-1$
                keypair = artifact.getName();
              }
              
              // Check if keypair in description is available on AWS -
              // If not import it from workspace and upload to AWS
              // FIXME - Cannon import an existing key to AWS with Jclouds
              // if (keypair != null) {
              // String encodedPublicKey = importKeyPair(keypair, this.project);
              // //Strip extension. - Get file name only
              //                  keypairName = keypair.substring( 0, keypair.indexOf( "." ) ); //$NON-NLS-1$
              // try {
              // /* Get current key pair in Amazon */
              // // DescribeKeyPairsRequest describeKeyPairsRequest = new
              // DescribeKeyPairsRequest();
              // this.ec2.getEC2Api().getKeyPairApi();
              // this.ec2.describeKeyPairs(
              // describeKeyPairsRequest.withKeyNames( keypairName ) );
              //
              // if (describeKeyPairsResult.getKeyPairs().size() == 0) {
              // ImportKeyPairRequest importKeyRequest = new
              // ImportKeyPairRequest( keypairName, encodedPublicKey );
              // this.ec2.importKeyPair( importKeyRequest );
              // }
              //
              // } catch( AmazonServiceException ase ) {
              // throw ase;
              // }
              //
              // }
            }
            
             Optional<? extends InstanceApi> instanceApi =
             this.ec2.getEC2Api().getInstanceApiForRegion(
             this.ec2.getRegion() );
             RunInstancesOptions options = RunInstancesOptions.Builder.asType(InstanceType.M1_SMALL).withKeyName(keypair);
             instanceApi.get().runInstancesInRegion( this.ec2.getRegion(),
             null, amiID, minCount, maxCount, options );
               
          }
        }
      }
    }


  }
  
  
  
  /**
   * @param project 
   * @param ec2 
   * @param keyp
   * @throws IOException 
   */
  private static String importKeyPair( final String publicKeyFile, final ICloudProject project) throws IOException {    
    /* Read Public Key */
    String encodedPublicKey = null;
    BufferedReader br = null;
    try {
     
//      ICloudElement element = CloudModel.getRoot().findChildWithResource( publicKeyFile );
      
      // For now get the File 
      // TODO - Incorporate Keypairs in CloudModel
      File file = new File(Platform.getLocation() + "/" + project.getName() + "/Artifacts/Deployment Scripts/" + publicKeyFile); //$NON-NLS-1$ //$NON-NLS-2$
           
      br = new BufferedReader( new FileReader( file ) );
      encodedPublicKey = br.readLine();
      
    } catch (IOException ioe) {
        throw ioe;
    } finally {
        if (br != null) {
            try {
                br.close();
                br = null;
            } catch (IOException ioe) {
                throw ioe;
            }
        }
    }
    return encodedPublicKey.trim();
  }
}
