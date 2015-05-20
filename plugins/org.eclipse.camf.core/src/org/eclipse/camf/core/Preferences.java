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
 *  Andreas Kastanas - added getDeploymentsStatus & setDeploymentStatus
 *******************************************************************************/
package org.eclipse.camf.core;

import org.eclipse.camf.core.internal.Activator;

/**
 * This class gives easy access to the core preferences of c-Eclipse.
 * 
 * @author Nicholas Loulloudes
 */
public class Preferences {

	/**
	 * Set the name of the current default Cloud Provider.
	 * 
	 * @param defaultCloudProviderName
	 *            The name of the default Cloud Provider.
	 */
	static public void setDefaultCloudProviderName(
			final String defaultCloudProviderName) {
		org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
		preferenceStore.setValue(PreferenceConstants.DEFAULT_CLOUD_PROVIDER_ID,
				defaultCloudProviderName);
	}

	/**
	 * Get the name of the current default Cloud Provider.
	 * 
	 * @return The name of the default Cloud Provider.
	 */
	static public String getDefaultVoName() {
		org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
		String defaultVoName = preferenceStore
				.getString(PreferenceConstants.DEFAULT_CLOUD_PROVIDER_ID);
		return defaultVoName;
	}

	/**
	 * Get the deployment JSON string.
	 * 
	 * @return The name of the default Cloud Provider.
	 */
	static public String getDeploymentsStatus() {
		org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
		String deployments = preferenceStore
				.getString(PreferenceConstants.DEPLOYMENTS);
		return deployments;
	}

	/**
	 * Set the value of the Deployment JSON string.
	 * 
	 * @param deploymentValue
	 *            The deployment JSON value.
	 */
	static public void setDeploymentStatus(final String deploymentValue) {
		org.eclipse.core.runtime.Preferences preferenceStore = getPreferenceStore();
		preferenceStore.setValue(PreferenceConstants.DEPLOYMENTS,
				deploymentValue);
	}

	/**
	 * Save these preferences to the preference store. This method just calls
	 * <code>Activator.getDefault().savePluginPreferences();</code>.
	 */
	static public void save() {
		Activator.getDefault().savePluginPreferences();
	}

	/**
	 * Get the preference store of the core preferences.
	 * 
	 * @return The preference store
	 */
	static protected org.eclipse.core.runtime.Preferences getPreferenceStore() {
		org.eclipse.core.runtime.Preferences preferenceStore = null;
		Activator activator = Activator.getDefault();
		if (activator != null) {
			preferenceStore = activator.getPluginPreferences();
		}
		return preferenceStore;
	}

}
