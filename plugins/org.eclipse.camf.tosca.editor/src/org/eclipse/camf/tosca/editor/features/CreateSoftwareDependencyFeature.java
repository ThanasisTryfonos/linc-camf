/*******************************************************************************
 * Copyright (c) 2013 Laboratory for Internet Computing, University of Cyprus.
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
 *   Stalo Sofokleous - initial API and implementation
 *   Nicholas Loulloudes - API and implementation extensions
 *   
 *******************************************************************************/
package org.eclipse.camf.tosca.editor.features;

import java.io.File;

import javax.xml.namespace.QName;

import org.eclipse.camf.tosca.ArtifactReferencesType;
import org.eclipse.camf.tosca.DefinitionsType;
import org.eclipse.camf.tosca.ImplementationArtifactType;
import org.eclipse.camf.tosca.PropertiesType;
import org.eclipse.camf.tosca.TArtifactReference;
import org.eclipse.camf.tosca.TArtifactTemplate;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TDeploymentArtifacts;
import org.eclipse.camf.tosca.TImplementationArtifacts;
import org.eclipse.camf.tosca.TNodeTemplate;
import org.eclipse.camf.tosca.TNodeTypeImplementation;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.editor.ModelHandler;
import org.eclipse.camf.tosca.editor.ToscaModelLayer;
import org.eclipse.camf.tosca.elasticity.ScriptArtifactPropertiesType;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsFactory;
import org.eclipse.camf.tosca.elasticity.Tosca_Elasticity_ExtensionsPackage;
import org.eclipse.camf.tosca.elementCreators.CreateArtifactTemplate;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
//import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;

public class CreateSoftwareDependencyFeature extends AbstractCreateFeature {

	  private Object contextObject = null;

	  public CreateSoftwareDependencyFeature( final IFeatureProvider fp ) {
	    // set name and description of the creation feature
	    super( fp, "Software Dependency", "Software Dependency" ); //$NON-NLS-1$ //$NON-NLS-2$
	  }

	  public void setContextObject( final Object obj ) {
	    this.contextObject = obj;
	  }

	  // Checks if user can create a software dependency object in the target
	  // business object
	  @Override
	  public boolean canCreate( final ICreateContext context ) {
	    return !( context.getTargetContainer() instanceof Diagram );
	  }

	  // Creates the business object for the software dependency
	  @Override
	  public Object[] create( final ICreateContext context ) {
	    if( this.contextObject == null )
	      return null;
	    Object parentObject = getFeatureProvider().getBusinessObjectForPictogramElement( context.getTargetContainer() );
	    TNodeTemplate tNode = null;
	    if( parentObject == null )
	      return null;
	    if( parentObject instanceof TNodeTemplate ) {
	      tNode = ( TNodeTemplate )parentObject;
	    }
	    if( tNode.getName() == null ) {
	      MessageDialog.openError( null,
	                               "Error",
	                               "Give a Name to the selected Component and try again." );
	      return null;
	    }
	    TArtifactTemplate artifactTemplate = ( TArtifactTemplate )this.contextObject;
	    // Create Script Artifact Template
	    CreateArtifactTemplate artTempl = new CreateArtifactTemplate(artifactTemplate.getId(), artifactTemplate.getType(), ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) ));
	    TArtifactTemplate newArtifactTemplate = artTempl.getNewArtifactTemplate();
	    
	    // Create Implementation Artifact
	    createImplementationArtifact( new QName( tNode.getName() ), artifactTemplate.getType(),
	                                  new QName( artifactTemplate.getId()) );
	            
	    //addGraphicalRepresentation( context, artifactTemplate );
	    addGraphicalRepresentation( context, newArtifactTemplate );
	    
	    // activate direct editing after object creation
	    getFeatureProvider().getDirectEditingInfo().setActive( true );
	    // return newly created business object(s)
	    return new Object[]{
	      newArtifactTemplate
	    };
	  }

	  // Creates the install implementation artifact
	  private void createImplementationArtifact( QName nodeType, QName artifactType,
	                                                                   QName artifactID )
	  {

	    final ToscaModelLayer model = ModelHandler.getModel( EcoreUtil.getURI( getDiagram() ) );
	    DefinitionsType definitions = model.getDocumentRoot().getDefinitions();
	    
	    TNodeTypeImplementation nodeTypeImplementation = null;
	    // Test if NodeTypeImplementation for nodeType already exists
	    for( TNodeTypeImplementation tempNodeTypeImplementation : definitions.getNodeTypeImplementation() )
	    {
	      if( tempNodeTypeImplementation.getNodeType()
	        .toString()
	        .equals( nodeType.toString() ) )
	      {
	        // NodeTypeImplementation already exists
	        // We are going to add the artifact to the existing implementation
	        nodeTypeImplementation = tempNodeTypeImplementation;
	      }
	    }
	    if( nodeTypeImplementation == null ) {
	      // NodeTypeImplementation does not exists
	      final TNodeTypeImplementation newNodeTypeImplementation = ToscaFactory.eINSTANCE.createTNodeTypeImplementation();
	      newNodeTypeImplementation.setNodeType( nodeType );
	      newNodeTypeImplementation.setName( "name" );
	      TImplementationArtifacts implementationArtifacts = ToscaFactory.eINSTANCE.createTImplementationArtifacts();
	      newNodeTypeImplementation.setImplementationArtifacts( implementationArtifacts );
	      
	      TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( definitions );
	      editingDomain.getCommandStack()
	        .execute( new RecordingCommand( editingDomain ) {

	          @Override
	          protected void doExecute() {
	            model.getDocumentRoot().getDefinitions().getNodeTypeImplementation()
	              .add( newNodeTypeImplementation );
	          }
	        } );
	      
	      nodeTypeImplementation = newNodeTypeImplementation;
	    }
	    // Create Implementation Artifact
	    final ImplementationArtifactType installArtifactType = ToscaFactory.eINSTANCE.createImplementationArtifactType();
	    installArtifactType.setArtifactType( artifactType );
	    installArtifactType.setArtifactRef( artifactID );
	    installArtifactType.setInterfaceName( "Lifecycle" );
	    installArtifactType.setOperationName( "execute" );
	    final TNodeTypeImplementation nodeImplementation = nodeTypeImplementation;
	    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain( nodeTypeImplementation );
	    editingDomain.getCommandStack()
	      .execute( new RecordingCommand( editingDomain ) {

	        @Override
	        protected void doExecute() {
	          nodeImplementation.getImplementationArtifacts()
	            .getImplementationArtifact()
	            .add( installArtifactType );
	        }
	      } );
	  }
	}
