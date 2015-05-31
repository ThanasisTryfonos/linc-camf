/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Security</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.Security#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getSecurity()
 * @model
 * @generated
 */
public interface Security extends EObject
{
  /**
   * Returns the value of the '<em><b>Keys</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.camf.infosystem.model.base.KeyPair}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Keys</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Keys</em>' containment reference list.
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getSecurity_Keys()
   * @model containment="true" required="true"
   * @generated
   */
  EList<KeyPair> getKeys();

} // Security
