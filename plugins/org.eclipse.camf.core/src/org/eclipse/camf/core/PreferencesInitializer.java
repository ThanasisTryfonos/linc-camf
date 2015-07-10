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
 * 	Nicholas Loulloudes - initial API and implementation
 *  Stalo Sofokleous - implementation
 *******************************************************************************/
package org.eclipse.camf.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.camf.core.internal.Activator;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.model.impl.GenericCloudProvider;
import org.eclipse.camf.core.model.impl.GenericCloudProviderCreator;
import org.eclipse.camf.core.reporting.ProblemException;


public class PreferencesInitializer extends AbstractPreferenceInitializer {

  /**
   * Initializes the eu.celar.core.prefs file with the registered Cloud providers' details.
   */
  @Override
  public void initializeDefaultPreferences() {
	    GenericCloudProviderCreator creator = null;
	    
	    creator = new GenericCloudProviderCreator();
	    creator.setVoName("Okeanos");
	    creator.setVoURI("http://83.212.122.157");
	    creator.setVoPort("8080");
	    
	    GenericCloudProvider cp = createVo( creator );
	    Preferences.addCloudProvider( cp );
  }
  
  // Method from class GenericCloudProviderWizard
  private static GenericCloudProvider createVo( final GenericCloudProviderCreator creator ) {
    
    IStatus result = Status.OK_STATUS;
    
    GenericCloudProvider vo = null;
    ICloudProviderManager manager = CloudModel.getCloudProviderManager();
    
    try {
      
        vo = ( GenericCloudProvider ) manager.create( creator );
      
    } catch ( ProblemException pExc ) {
      result = new Status( IStatus.ERROR, Activator.PLUGIN_ID, pExc.getLocalizedMessage(), pExc );
    }
    
    if ( ! result.isOK() && ( vo != null ) ) {
      try {
        manager.delete( vo );
      } catch ( ProblemException pExc ) {
        Activator.logException( pExc );
      }
    }
    
    return vo;
    
  }
}
