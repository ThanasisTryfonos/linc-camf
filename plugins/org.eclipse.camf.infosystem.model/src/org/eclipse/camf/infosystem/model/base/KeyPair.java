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
 *  Andreas Kastanas - added description field
 *******************************************************************************/
/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.KeyPair#getUID <em>UID</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.KeyPair#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.KeyPair#getPublicKey <em>Public Key</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.KeyPair#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.KeyPair#getURL <em>URL</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getKeyPair()
 * @model extendedMetaData="name='KeyPair' kind='elementOnly'"
 * @generated
 */
public interface KeyPair extends EObject
{
  /**
   * Returns the value of the '<em><b>UID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>UID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>UID</em>' attribute.
   * @see #setUID(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getKeyPair_UID()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='UID' namespace='##targetNamespace'"
   * @generated
   */
  String getUID();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getUID <em>UID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>UID</em>' attribute.
   * @see #getUID()
   * @generated
   */
  void setUID(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getKeyPair_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='Name' namespace='##targetNamespace'"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Public Key</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Public Key</em>' attribute.
   * @see #setPublicKey(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getKeyPair_PublicKey()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getPublicKey();

		/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getPublicKey <em>Public Key</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Public Key</em>' attribute.
   * @see #getPublicKey()
   * @generated
   */
	void setPublicKey(String value);

		/**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getKeyPair_Description()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   * @generated
   */
	String getDescription();

		/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
	void setDescription(String value);

		/**
   * Returns the value of the '<em><b>URL</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>URL</em>' attribute.
   * @see #setURL(String)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getKeyPair_URL()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
   *        extendedMetaData="kind='element' name='URL' namespace='##targetNamespace'"
   * @generated
   */
	String getURL();

		/**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getURL <em>URL</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>URL</em>' attribute.
   * @see #getURL()
   * @generated
   */
	void setURL(String value);

} // KeyPair
