/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cloud Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.CloudProvider#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.CloudProvider#getImages <em>Images</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.CloudProvider#getNetworks <em>Networks</em>}</li>
 *   <li>{@link org.eclipse.camf.infosystem.model.base.CloudProvider#getSecurity <em>Security</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getCloudProvider()
 * @model
 * @generated
 */
public interface CloudProvider extends EObject
{
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
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getCloudProvider_Name()
   * @model dataType="org.eclipse.emf.ecore.xml.type.String"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.CloudProvider#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Images</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Images</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Images</em>' containment reference.
   * @see #setImages(Images)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getCloudProvider_Images()
   * @model containment="true" required="true"
   * @generated
   */
  Images getImages();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.CloudProvider#getImages <em>Images</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Images</em>' containment reference.
   * @see #getImages()
   * @generated
   */
  void setImages(Images value);

  /**
   * Returns the value of the '<em><b>Networks</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Networks</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Networks</em>' containment reference.
   * @see #setNetworks(Networks)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getCloudProvider_Networks()
   * @model containment="true" required="true"
   * @generated
   */
  Networks getNetworks();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.CloudProvider#getNetworks <em>Networks</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Networks</em>' containment reference.
   * @see #getNetworks()
   * @generated
   */
  void setNetworks(Networks value);

  /**
   * Returns the value of the '<em><b>Security</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Security</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Security</em>' containment reference.
   * @see #setSecurity(Security)
   * @see org.eclipse.camf.infosystem.model.base.InfoSystemPackage#getCloudProvider_Security()
   * @model containment="true" required="true"
   * @generated
   */
  Security getSecurity();

  /**
   * Sets the value of the '{@link org.eclipse.camf.infosystem.model.base.CloudProvider#getSecurity <em>Security</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Security</em>' containment reference.
   * @see #getSecurity()
   * @generated
   */
  void setSecurity(Security value);

} // CloudProvider
