/*******************************************************************************

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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack.info;

import java.net.URI;
import java.util.ArrayList;

import org.eclipse.camf.connectors.openstack.OpenStackApplicationDeploymentService;
import org.eclipse.camf.connectors.openstack.OpenStackClient;
import org.eclipse.camf.connectors.openstack.OpenStackCloudProvider;
import org.eclipse.camf.connectors.openstack.OpenStackService;
import org.eclipse.camf.connectors.openstack.internal.Activator;
import org.eclipse.camf.connectors.openstack.internal.Messages;
import org.eclipse.camf.connectors.openstack.operation.AbstractOpenStackOpDescribeImages;
import org.eclipse.camf.connectors.openstack.operation.AbstractOpenStackOpKeyPairs;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDescribeImages;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpDescribeKeyPairs;
import org.eclipse.camf.connectors.openstack.operation.OpenStackOpExceptions;
import org.eclipse.camf.connectors.openstack.operation.OperationExecuter;
import org.eclipse.camf.core.model.ICloudContainer;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudResource;
import org.eclipse.camf.core.model.ICloudResourceCategory;
import org.eclipse.camf.core.model.ICloudService;
import org.eclipse.camf.core.model.impl.AbstractCloudInfoSystem;
import org.eclipse.camf.core.model.impl.CloudResourceCategoryFactory;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.infosystem.InfoService;
import org.eclipse.camf.infosystem.model.base.AbstractInfoCache;
import org.eclipse.camf.infosystem.model.base.CloudProvider;
import org.eclipse.camf.infosystem.model.base.IExtendedInfoService;
import org.eclipse.camf.infosystem.model.base.Images;
import org.eclipse.camf.infosystem.model.base.InfoSystemFactory;
import org.eclipse.camf.infosystem.model.base.Root;
import org.eclipse.camf.infosystem.model.base.Security;
import org.eclipse.camf.infosystem.model.base.VMI;
import org.eclipse.camf.infosystem.model.base.VirtualMachineImage;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.jclouds.compute.domain.Image;
import org.jclouds.openstack.nova.v2_0.domain.KeyPair;

/**
 * @author Nicholas Loulloudes
 *
 */
public class OpenStackInfoService extends AbstractCloudInfoSystem implements IExtendedInfoService {
  
  /** The name of the file to save this grid element in. */
  public static String STORAGE_NAME = ".osInfoService"; //$NON-NLS-1$
  private OpenStackCloudProvider osCP;
  
  
  public OpenStackInfoService (final OpenStackCloudProvider cp) {
    this.osCP = cp;
  }
  
  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudResource#getURI()
   */
  @Override
  public URI getURI() throws ProblemException {
    return this.osCP.getProperties().getOpenStackEndpoint(); //$NON-NLS-1$
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getName()
   */
  @Override
  public String getName() {
      String result = "OpenStack @ ";
      try {
        result += getURI();
    } catch (ProblemException e) {
        e.printStackTrace();
    } //$NON-NLS-1$
      return result;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getFileStore()
   */
  @Override
  public IFileStore getFileStore() {
    return getParent().getFileStore().getChild( OpenStackInfoService.STORAGE_NAME );

  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getPath()
   */
  @Override
  public IPath getPath() {
    return getParent().getPath().append( OpenStackInfoService.STORAGE_NAME );
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getResource()
   */
  @Override
  public IResource getResource() {
    return null;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#getParent()
   */
  @Override
  public ICloudContainer getParent() {
    return this.osCP;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudElement#isLocal()
   */
  @Override
  public boolean isLocal() {
    return true;
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.IShareableElement#share()
   */
  @Override
  public void share() throws ProblemException {
    // TODO Auto-generated method stub
  }

  /* (non-Javadoc)
   * @see org.eclipse.camf.core.model.ICloudInfoService#fetchResources(org.eclipse.camf.core.model.ICloudContainer, org.eclipse.camf.core.model.ICloudProvider, boolean, java.lang.Class, org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public ICloudResource[] fetchResources( final ICloudContainer parent,
                                          final ICloudProvider cp,
                                          final ICloudResourceCategory category,
                                          final boolean exclusive,
                                          final Class<? extends ICloudResource> typeFilter,
                                          final IProgressMonitor monitor )
    throws ProblemException
  {
    
    
    ICloudResource[] result = null;
    
    if( category.equals( CloudResourceCategoryFactory.getCategory( IOpenStackCategories.CATEGORY_OPENSTACK_IMAGES ) ) )
    {

      result = fetchImages( parent,
                            cp,
                            monitor,
                            new OpenStackOpDescribeImages( getClient() ) );
    } else if ( category.equals( CloudResourceCategoryFactory.getCategory( IOpenStackCategories.CATEGORY_OPENSTACK_SECURITY ) ) )
    {

      result = fetchKeyPairs( parent,
                            cp,
                            monitor,
                            new OpenStackOpDescribeKeyPairs( getClient() ) );
    } else if( category.equals( CloudResourceCategoryFactory.getCategory( CloudResourceCategoryFactory.ID_DEPLOYMENT_SERVICES ) ) )
    {
      result = fetchDeploymentServices( parent, cp, monitor );
    }

    if (result == null)
      result = new ICloudResource[0];

    return result;
  }
  
  /**
   * Fetches the available AMIs of the OpenStack service using the owner as a filter.
   * 
   * @param parent the parent of this {@link IGridInfoService}
   * @param vo the vo initiating the query
   * @param monitor the monitor to notify of progress
   * @param operation the operation to execute
   * @return an array of {@link OpenStackAMIImage}s.
   */
  public ICloudResource[] fetchImages( final ICloudContainer parent,
                                      final ICloudProvider cp,
                                      IProgressMonitor monitor,
                                      final AbstractOpenStackOpDescribeImages operation )
  {
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }
    try {
      // fetch existing AMI images from OpenStack service
      monitor.beginTask( Messages.getString( "OpenStackInfoService.monitor_task_description" ), //$NON-NLS-1$
                         2 );
      new OperationExecuter().execOp( operation );
      monitor.worked( 1 );
      if( operation.getException() == null ) {
        // transform answer into gEclipse format
        ArrayList<ICloudResource> resultCloudService = new ArrayList<ICloudResource>( operation.getResult()
          .size() );
        Root root = InfoService.getInstance().getRoot();
        boolean newCP = false;
        CloudProvider infoCP = InfoService.getInstance().getCloudProvider( cp );
        if( infoCP == null ) {
          infoCP = InfoService.getInstance().getFactory().createCloudProvider();
          infoCP.setName( cp.getName() );
          newCP = true;
        }
        Images images = InfoService.getInstance().getFactory().createImages();
        infoCP.setImages( images );
        for( Image ami : operation.getResult() ) {
          VirtualMachineImage vmi = InfoSystemFactory.eINSTANCE.createVirtualMachineImage();
          vmi.setUID( ami.getId() );
          vmi.setDescription( ami.getDescription() );
          vmi.setName( ami.getName() );
          vmi.setURL( ami.getLocation().toString() );
          resultCloudService.add( new VMI( parent, vmi ) );
          images.getVms().add( vmi );
        }
        if( newCP )
          root.getCloudProviders().add( infoCP );
        monitor.worked( 2 );
        monitor.done();
        return resultCloudService.toArray( new ICloudResource[ resultCloudService.size() ] );
      } else {
        throw new OpenStackOpExceptions( "Failed to get images  list. Please contact your system administrator",
                                         OpenStackOpExceptions.ExceptionType.IMAGES );
      }
    } catch( Exception e ) {
      e.printStackTrace();
    }
    return null;
  }
  
  /**
   * Fetches the available KeyPairs of the OpenStack service using the owner as a filter.
   * 
   * @param parent the parent of this {@link IGridInfoService}
   * @param vo the vo initiating the query
   * @param monitor the monitor to notify of progress
   * @param operation the operation to execute
   * @return an array of {@link OpenStackAMIImage}s.
   */
  public ICloudResource[] fetchKeyPairs( final ICloudContainer parent,
                                      final ICloudProvider cp,
                                      IProgressMonitor monitor,
                                      final AbstractOpenStackOpKeyPairs operation )
  {
    try {
      if( monitor == null ) {
        monitor = new NullProgressMonitor();
      }

      // fetch existing AMI images from OpenStack service
      monitor.beginTask( Messages.getString( "OpenStackInfoService.monitor_task_description" ), //$NON-NLS-1$
                         2 );

      new OperationExecuter().execOp( operation );

      monitor.worked( 1 );
      if( operation.getException() == null ) {
        Root root = InfoService.getInstance().getRoot();
        boolean newCP = false;
        CloudProvider infoCP = InfoService.getInstance().getCloudProvider( cp );
        if( infoCP == null ) {
          infoCP = InfoService.getInstance().getFactory().createCloudProvider();
          infoCP.setName( cp.getName() );
          newCP = true;
        }
        Security security = InfoService.getInstance()
          .getFactory()
          .createSecurity();
        infoCP.setSecurity( security );
        for( KeyPair remoteKeyPair : operation.getResult() ) {
          org.eclipse.camf.infosystem.model.base.KeyPair kp = InfoSystemFactory.eINSTANCE.createKeyPair();
          kp.setName( remoteKeyPair.getName() );
          kp.setUID( remoteKeyPair.getFingerprint() );
          security.getKeys().add( kp );
        }
        if( newCP )
          root.getCloudProviders().add( infoCP );
        monitor.worked( 2 );
        monitor.done();
        return null;
      } else {
        throw new OpenStackOpExceptions( "Failed to get keypairs. Please contact your system administrator",
                                         OpenStackOpExceptions.ExceptionType.KEYPAIR );
      }
    } catch( Exception e ) {
      e.printStackTrace();
    }
    
    return null;
  }
    
  private ICloudService[] fetchDeploymentServices( final ICloudContainer parent,
                                                   final ICloudProvider cp,
                                                   IProgressMonitor monitor )
  {
    ArrayList<ICloudService> servicesList = new ArrayList<ICloudService>();
    if( monitor == null ) {
      monitor = new NullProgressMonitor();
    }
    monitor.beginTask( "Fetching OpenStack Deployment Service", 1 );
    OpenStackApplicationDeploymentService deploymentService = new OpenStackApplicationDeploymentService( parent );
    servicesList.add( deploymentService );
    monitor.worked( 2 );
    monitor.done();
    return servicesList.toArray( new ICloudService[ servicesList.size() ] );
  }
  
  private OpenStackClient getClient() {
    return OpenStackClient.getInstance();
 }

  @Override
  public AbstractInfoCache getInfoCache() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
