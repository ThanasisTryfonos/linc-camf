/*****************************************************************************
 * Copyright (c) 2006-2008 g-Eclipse Consortium 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial development of the original code was made for the
 * g-Eclipse project founded by European Union
 * project number: FP6-IST-034327  http://www.geclipse.eu/
 *
 * Contributors:
 *    Mathias Stuempert - initial API and implementation
 *    Nicholas Loulloudes - code adapter for CELAR project, 2013
 *****************************************************************************/
package org.eclipse.camf.core.model.impl;

import org.eclipse.camf.core.model.ICloudApplicationDescription;
import org.eclipse.camf.core.model.ICloudDeploymentCreator;

/**
 * Abstract implementation of the {@link ICloudDeploymentCreator} interface
 * that delegates the {@link #canCreate(ICloudApplicationDescription)} method to
 * an internal one and handles the storage of the argument of this
 * function.
 */
public abstract class AbstractCloudDeploymentCreator
    extends AbstractCloudElementCreator
    implements ICloudDeploymentCreator {
  
  /**
   * The job description from the last successful call of the
   * {@link #canCreate(ICloudApplicationDescription)} method.
   */
  private ICloudApplicationDescription internalDescription;

  @Override
  public boolean canCreate( final ICloudApplicationDescription description ) {
    boolean result = internalCanCreate( description );
    if ( result ) {
      this.internalDescription = description;
    }
    return result;
  }
  
  /**
   * Get the job description from the last successful call of the
   * {@link #canCreate(ICloudApplicationDescription)} method.
   * 
   * @return The argument of the last successful call of the
   * {@link #canCreate(ICloudApplicationDescription)} method.
   */
  public ICloudApplicationDescription getDescription() {
    return this.internalDescription;
  }
  
  /**
   * Internal method to determine if this creator is potentially 
   * able to create jobs from the specified description. This method
   * is called from {@link #canCreate(ICloudApplicationDescription)} and has
   * not to care about storing the passed object since this is
   * handled by the {@link #canCreate(ICloudApplicationDescription)} method.
   * Therefore this method may never be called directly.
   * 
   * @param description The description from which the job should be
   * created.
   * @return True if this creator is potentially able to create a
   * job from the specified description.
   */
  protected abstract boolean internalCanCreate( final ICloudApplicationDescription description );
  
}
