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
 * 	Nicholas Loulloudes - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.connectors.openstack;

import java.net.URL;

import org.eclipse.camf.core.model.ICloudElementCreator;


/**
 * This interface acts as a gateway to an service creator. The decisive factor
 * is to fetch the services name and the corresponding service {@link URL}. A
 * common scenario is to extract these details from this
 * <code>org.eclipse.camf.core.cloudElementCreator</code> extension point defining
 * the {@link ICloudElementCreator}.
 * 

 */
public interface IOpenStackServiceCreator extends ICloudElementCreator {

  /**
   * Set the name of the service creator.
   * 
   * @param name the name to set
   */
  public void setName( String name );

  /**
   * Get the name of the service creator
   * 
   * @return the name of the creator
   */
  public String getName();

  /**
   * Set the url the service interacts with.
   * 
   * @param url the url to set
   */
  public void setServiceURL( String url );

  /**
   * Gets the service url of the service to be created.
   * 
   * @return the service url to get
   */
  public String getServiceURL();
}
