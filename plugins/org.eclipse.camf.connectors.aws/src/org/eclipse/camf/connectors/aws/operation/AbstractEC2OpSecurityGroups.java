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
package org.eclipse.camf.connectors.aws.operation;

import java.util.List;

import org.jclouds.ec2.domain.SecurityGroup;


/**
 * This base class provides some common functionality for classes wanting to
 * fetch the list of available SecurityGroups.
 *
 * @author Nicholas Loulloudes
 */
public abstract class AbstractEC2OpSecurityGroups implements IOperation {

	/** The resulting list of Instances */
	private List<SecurityGroup> result;

	/** Any exception which came up during the inquiry. */
	private Exception exception;

	abstract public void run();

	public List<SecurityGroup> getResult() {
		return this.result;
	}

	public Exception getException() {
		return this.exception;
	}

	/**
	 * A setter for {@link #result}.
	 * 
	 * @param describedInstances
	 *            the param to set
	 */
	protected void setResult(final List<SecurityGroup> describedSecurityGroups) {
		this.result = describedSecurityGroups;
	}

	/**
	 * A setter for {@link #exception}.
	 * 
	 * @param ex
	 *            the exception to set
	 */
	protected void setException(final Exception ex) {
		this.exception = ex;
	}
}
