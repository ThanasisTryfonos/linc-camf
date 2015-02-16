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
 *   Nicholas Loulloudes - initial API and implementation
 *   
 *******************************************************************************/
package org.eclipse.camf.core.model;

import java.net.URI;

import org.eclipse.camf.core.reporting.ProblemException;


/**
 * @author Nicholas Loulloudes
 *
 */
public interface ICloudVirtualMachineImage extends ICloudApplicationComponent {
  
  public String getName();
  
  public String getDescription();
  
  public String getUID();
  
  public URI getURI() throws ProblemException;
}
