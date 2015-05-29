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
/**
 */
package org.eclipse.camf.infosystem.model.base;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.camf.infosystem.model.base.InfoSystemFactory
 * @model kind="package"
 * @generated
 */
public interface InfoSystemPackage extends EPackage
{
  /**
	 * The package name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNAME = "base";

  /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_URI = "http://www.example.org/InfoSystem";

  /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  String eNS_PREFIX = "base";

  /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  InfoSystemPackage eINSTANCE = org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl.init();

  /**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.MonitoringProbeImpl <em>Monitoring Probe</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.MonitoringProbeImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getMonitoringProbe()
	 * @generated
	 */
  int MONITORING_PROBE = 0;

  /**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MONITORING_PROBE__UID = 0;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MONITORING_PROBE__NAME = 1;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MONITORING_PROBE__DESCRIPTION = 2;

  /**
	 * The feature id for the '<em><b>Metrics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MONITORING_PROBE__METRICS = 3;

		/**
	 * The number of structural features of the '<em>Monitoring Probe</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int MONITORING_PROBE_FEATURE_COUNT = 4;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.ResizingActionImpl <em>Resizing Action</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.ResizingActionImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getResizingAction()
	 * @generated
	 */
  int RESIZING_ACTION = 1;

  /**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RESIZING_ACTION__UID = 0;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RESIZING_ACTION__NAME = 1;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RESIZING_ACTION__DESCRIPTION = 2;

  /**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RESIZING_ACTION__URL = 3;

  /**
	 * The number of structural features of the '<em>Resizing Action</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int RESIZING_ACTION_FEATURE_COUNT = 4;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.SoftwareDependencyImpl <em>Software Dependency</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.SoftwareDependencyImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getSoftwareDependency()
	 * @generated
	 */
  int SOFTWARE_DEPENDENCY = 2;

  /**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SOFTWARE_DEPENDENCY__UID = 0;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SOFTWARE_DEPENDENCY__NAME = 1;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SOFTWARE_DEPENDENCY__DESCRIPTION = 2;

  /**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SOFTWARE_DEPENDENCY__URL = 3;

  /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SOFTWARE_DEPENDENCY__TYPE = 4;

  /**
	 * The number of structural features of the '<em>Software Dependency</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int SOFTWARE_DEPENDENCY_FEATURE_COUNT = 5;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageImpl <em>Virtual Machine Image</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImage()
	 * @generated
	 */
  int VIRTUAL_MACHINE_IMAGE = 3;

  /**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_MACHINE_IMAGE__UID = 0;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_MACHINE_IMAGE__NAME = 1;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_MACHINE_IMAGE__DESCRIPTION = 2;

  /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_MACHINE_IMAGE__TYPE = 3;

  /**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_MACHINE_IMAGE__URL = 4;

  /**
	 * The number of structural features of the '<em>Virtual Machine Image</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_MACHINE_IMAGE_FEATURE_COUNT = 5;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.UserApplicationImpl <em>User Application</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.UserApplicationImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getUserApplication()
	 * @generated
	 */
  int USER_APPLICATION = 4;

  /**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER_APPLICATION__UID = 0;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER_APPLICATION__NAME = 1;

  /**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER_APPLICATION__DESCRIPTION = 2;

  /**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER_APPLICATION__URL = 3;

  /**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER_APPLICATION__TYPE = 4;

  /**
	 * The number of structural features of the '<em>User Application</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int USER_APPLICATION_FEATURE_COUNT = 5;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.KeyPairImpl <em>Key Pair</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.KeyPairImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getKeyPair()
	 * @generated
	 */
  int KEY_PAIR = 5;

  /**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int KEY_PAIR__UID = 0;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int KEY_PAIR__NAME = 1;

  /**
	 * The feature id for the '<em><b>Public Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PAIR__PUBLIC_KEY = 2;

		/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PAIR__DESCRIPTION = 3;

		/**
	 * The feature id for the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PAIR__URL = 4;

		/**
	 * The number of structural features of the '<em>Key Pair</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int KEY_PAIR_FEATURE_COUNT = 5;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageFlavorImpl <em>Virtual Machine Image Flavor</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageFlavorImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageFlavor()
	 * @generated
	 */
  int VIRTUAL_MACHINE_IMAGE_FLAVOR = 6;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME = 0;

  /**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_MACHINE_IMAGE_FLAVOR__UID = 1;

  /**
	 * The feature id for the '<em><b>Ram</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM = 2;

		/**
	 * The feature id for the '<em><b>Hdd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD = 3;

		/**
	 * The feature id for the '<em><b>VCPU</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU = 4;

		/**
	 * The number of structural features of the '<em>Virtual Machine Image Flavor</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_MACHINE_IMAGE_FLAVOR_FEATURE_COUNT = 5;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.VirtualNetworkImpl <em>Virtual Network</em>}' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.VirtualNetworkImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualNetwork()
	 * @generated
	 */
  int VIRTUAL_NETWORK = 7;

  /**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_NETWORK__UID = 0;

  /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_NETWORK__NAME = 1;

  /**
	 * The number of structural features of the '<em>Virtual Network</em>' class.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
  int VIRTUAL_NETWORK_FEATURE_COUNT = 2;

  /**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.VirtualInstanceImpl <em>Virtual Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.VirtualInstanceImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualInstance()
	 * @generated
	 */
	int VIRTUAL_INSTANCE = 8;

		/**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_INSTANCE__UID = 0;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_INSTANCE__NAME = 1;

		/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_INSTANCE__STATUS = 2;

		/**
	 * The feature id for the '<em><b>IPs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_INSTANCE__IPS = 3;

		/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_INSTANCE__URI = 4;

		/**
	 * The number of structural features of the '<em>Virtual Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIRTUAL_INSTANCE_FEATURE_COUNT = 5;

		/**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.SecurityGroupImpl <em>Security Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.SecurityGroupImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getSecurityGroup()
	 * @generated
	 */
	int SECURITY_GROUP = 9;

		/**
	 * The feature id for the '<em><b>UID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_GROUP__UID = 0;

		/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_GROUP__NAME = 1;

		/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_GROUP__DESCRIPTION = 2;

		/**
	 * The number of structural features of the '<em>Security Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECURITY_GROUP_FEATURE_COUNT = 3;

		/**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.DeploymentImpl <em>Deployment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.DeploymentImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getDeployment()
	 * @generated
	 */
	int DEPLOYMENT = 10;

		/**
	 * The feature id for the '<em><b>Dep ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__DEP_ID = 0;

		/**
	 * The feature id for the '<em><b>Deployment Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__DEPLOYMENT_NAME = 1;

		/**
	 * The feature id for the '<em><b>Modules</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__MODULES = 2;

		/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT__STATUS = 3;

		/**
	 * The number of structural features of the '<em>Deployment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_FEATURE_COUNT = 4;

		/**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.impl.ModuleImpl
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 11;

		/**
	 * The feature id for the '<em><b>Mod ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MOD_ID = 0;

		/**
	 * The feature id for the '<em><b>Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__MODULE_NAME = 1;

		/**
	 * The feature id for the '<em><b>Instances</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__INSTANCES = 2;

		/**
	 * The feature id for the '<em><b>Init Instances</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__INIT_INSTANCES = 3;

		/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = 4;

		/**
	 * The meta object id for the '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageType <em>Virtual Machine Image Type</em>}' enum.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageType
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageType()
	 * @generated
	 */
  int VIRTUAL_MACHINE_IMAGE_TYPE = 12;

  /**
	 * The meta object id for the '<em>Virtual Machine Image Type Object</em>' data type.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageType
	 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageTypeObject()
	 * @generated
	 */
  int VIRTUAL_MACHINE_IMAGE_TYPE_OBJECT = 13;


  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe <em>Monitoring Probe</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Monitoring Probe</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.MonitoringProbe
	 * @generated
	 */
  EClass getMonitoringProbe();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.MonitoringProbe#getUID()
	 * @see #getMonitoringProbe()
	 * @generated
	 */
  EAttribute getMonitoringProbe_UID();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.MonitoringProbe#getName()
	 * @see #getMonitoringProbe()
	 * @generated
	 */
  EAttribute getMonitoringProbe_Name();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.MonitoringProbe#getDescription()
	 * @see #getMonitoringProbe()
	 * @generated
	 */
  EAttribute getMonitoringProbe_Description();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.MonitoringProbe#getMetrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metrics</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.MonitoringProbe#getMetrics()
	 * @see #getMonitoringProbe()
	 * @generated
	 */
	EAttribute getMonitoringProbe_Metrics();

		/**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.ResizingAction <em>Resizing Action</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resizing Action</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.ResizingAction
	 * @generated
	 */
  EClass getResizingAction();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.ResizingAction#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.ResizingAction#getUID()
	 * @see #getResizingAction()
	 * @generated
	 */
  EAttribute getResizingAction_UID();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.ResizingAction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.ResizingAction#getName()
	 * @see #getResizingAction()
	 * @generated
	 */
  EAttribute getResizingAction_Name();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.ResizingAction#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.ResizingAction#getDescription()
	 * @see #getResizingAction()
	 * @generated
	 */
  EAttribute getResizingAction_Description();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.ResizingAction#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.ResizingAction#getURL()
	 * @see #getResizingAction()
	 * @generated
	 */
  EAttribute getResizingAction_URL();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.SoftwareDependency <em>Software Dependency</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software Dependency</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SoftwareDependency
	 * @generated
	 */
  EClass getSoftwareDependency();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.SoftwareDependency#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SoftwareDependency#getUID()
	 * @see #getSoftwareDependency()
	 * @generated
	 */
  EAttribute getSoftwareDependency_UID();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.SoftwareDependency#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SoftwareDependency#getName()
	 * @see #getSoftwareDependency()
	 * @generated
	 */
  EAttribute getSoftwareDependency_Name();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.SoftwareDependency#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SoftwareDependency#getDescription()
	 * @see #getSoftwareDependency()
	 * @generated
	 */
  EAttribute getSoftwareDependency_Description();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.SoftwareDependency#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SoftwareDependency#getURL()
	 * @see #getSoftwareDependency()
	 * @generated
	 */
  EAttribute getSoftwareDependency_URL();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.SoftwareDependency#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SoftwareDependency#getType()
	 * @see #getSoftwareDependency()
	 * @generated
	 */
  EAttribute getSoftwareDependency_Type();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImage <em>Virtual Machine Image</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Machine Image</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImage
	 * @generated
	 */
  EClass getVirtualMachineImage();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getUID()
	 * @see #getVirtualMachineImage()
	 * @generated
	 */
  EAttribute getVirtualMachineImage_UID();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getName()
	 * @see #getVirtualMachineImage()
	 * @generated
	 */
  EAttribute getVirtualMachineImage_Name();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getDescription()
	 * @see #getVirtualMachineImage()
	 * @generated
	 */
  EAttribute getVirtualMachineImage_Description();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getType()
	 * @see #getVirtualMachineImage()
	 * @generated
	 */
  EAttribute getVirtualMachineImage_Type();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImage#getURL()
	 * @see #getVirtualMachineImage()
	 * @generated
	 */
  EAttribute getVirtualMachineImage_URL();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.UserApplication <em>User Application</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Application</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.UserApplication
	 * @generated
	 */
  EClass getUserApplication();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.UserApplication#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.UserApplication#getUID()
	 * @see #getUserApplication()
	 * @generated
	 */
  EAttribute getUserApplication_UID();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.UserApplication#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.UserApplication#getName()
	 * @see #getUserApplication()
	 * @generated
	 */
  EAttribute getUserApplication_Name();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.UserApplication#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.UserApplication#getDescription()
	 * @see #getUserApplication()
	 * @generated
	 */
  EAttribute getUserApplication_Description();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.UserApplication#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.UserApplication#getURL()
	 * @see #getUserApplication()
	 * @generated
	 */
  EAttribute getUserApplication_URL();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.UserApplication#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.UserApplication#getType()
	 * @see #getUserApplication()
	 * @generated
	 */
  EAttribute getUserApplication_Type();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.KeyPair <em>Key Pair</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Pair</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.KeyPair
	 * @generated
	 */
  EClass getKeyPair();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.KeyPair#getUID()
	 * @see #getKeyPair()
	 * @generated
	 */
  EAttribute getKeyPair_UID();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.KeyPair#getName()
	 * @see #getKeyPair()
	 * @generated
	 */
  EAttribute getKeyPair_Name();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getPublicKey <em>Public Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Public Key</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.KeyPair#getPublicKey()
	 * @see #getKeyPair()
	 * @generated
	 */
	EAttribute getKeyPair_PublicKey();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.KeyPair#getDescription()
	 * @see #getKeyPair()
	 * @generated
	 */
	EAttribute getKeyPair_Description();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.KeyPair#getURL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URL</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.KeyPair#getURL()
	 * @see #getKeyPair()
	 * @generated
	 */
	EAttribute getKeyPair_URL();

		/**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor <em>Virtual Machine Image Flavor</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Machine Image Flavor</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor
	 * @generated
	 */
  EClass getVirtualMachineImageFlavor();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getName()
	 * @see #getVirtualMachineImageFlavor()
	 * @generated
	 */
  EAttribute getVirtualMachineImageFlavor_Name();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getUID()
	 * @see #getVirtualMachineImageFlavor()
	 * @generated
	 */
  EAttribute getVirtualMachineImageFlavor_UID();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getRam <em>Ram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ram</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getRam()
	 * @see #getVirtualMachineImageFlavor()
	 * @generated
	 */
	EAttribute getVirtualMachineImageFlavor_Ram();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getHdd <em>Hdd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hdd</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getHdd()
	 * @see #getVirtualMachineImageFlavor()
	 * @generated
	 */
	EAttribute getVirtualMachineImageFlavor_Hdd();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getVCPU <em>VCPU</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>VCPU</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageFlavor#getVCPU()
	 * @see #getVirtualMachineImageFlavor()
	 * @generated
	 */
	EAttribute getVirtualMachineImageFlavor_VCPU();

		/**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.VirtualNetwork <em>Virtual Network</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Network</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualNetwork
	 * @generated
	 */
  EClass getVirtualNetwork();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualNetwork#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualNetwork#getUID()
	 * @see #getVirtualNetwork()
	 * @generated
	 */
  EAttribute getVirtualNetwork_UID();

  /**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualNetwork#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualNetwork#getName()
	 * @see #getVirtualNetwork()
	 * @generated
	 */
  EAttribute getVirtualNetwork_Name();

  /**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance <em>Virtual Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Virtual Instance</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualInstance
	 * @generated
	 */
	EClass getVirtualInstance();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualInstance#getUID()
	 * @see #getVirtualInstance()
	 * @generated
	 */
	EAttribute getVirtualInstance_UID();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualInstance#getName()
	 * @see #getVirtualInstance()
	 * @generated
	 */
	EAttribute getVirtualInstance_Name();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualInstance#getStatus()
	 * @see #getVirtualInstance()
	 * @generated
	 */
	EAttribute getVirtualInstance_Status();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getIPs <em>IPs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>IPs</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualInstance#getIPs()
	 * @see #getVirtualInstance()
	 * @generated
	 */
	EAttribute getVirtualInstance_IPs();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.VirtualInstance#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualInstance#getURI()
	 * @see #getVirtualInstance()
	 * @generated
	 */
	EAttribute getVirtualInstance_URI();

		/**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.SecurityGroup <em>Security Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Security Group</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SecurityGroup
	 * @generated
	 */
	EClass getSecurityGroup();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.SecurityGroup#getUID <em>UID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SecurityGroup#getUID()
	 * @see #getSecurityGroup()
	 * @generated
	 */
	EAttribute getSecurityGroup_UID();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.SecurityGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SecurityGroup#getName()
	 * @see #getSecurityGroup()
	 * @generated
	 */
	EAttribute getSecurityGroup_Name();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.SecurityGroup#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.SecurityGroup#getDescription()
	 * @see #getSecurityGroup()
	 * @generated
	 */
	EAttribute getSecurityGroup_Description();

		/**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.Deployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Deployment
	 * @generated
	 */
	EClass getDeployment();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.Deployment#getDepID <em>Dep ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dep ID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Deployment#getDepID()
	 * @see #getDeployment()
	 * @generated
	 */
	EAttribute getDeployment_DepID();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.Deployment#getDeploymentName <em>Deployment Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deployment Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Deployment#getDeploymentName()
	 * @see #getDeployment()
	 * @generated
	 */
	EAttribute getDeployment_DeploymentName();

		/**
	 * Returns the meta object for the reference list '{@link org.eclipse.camf.infosystem.model.base.Deployment#getModules <em>Modules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Modules</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Deployment#getModules()
	 * @see #getDeployment()
	 * @generated
	 */
	EReference getDeployment_Modules();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.Deployment#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Deployment#getStatus()
	 * @see #getDeployment()
	 * @generated
	 */
	EAttribute getDeployment_Status();

		/**
	 * Returns the meta object for class '{@link org.eclipse.camf.infosystem.model.base.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Module
	 * @generated
	 */
	EClass getModule();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.Module#getModID <em>Mod ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mod ID</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Module#getModID()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_ModID();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.Module#getModuleName <em>Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Module Name</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Module#getModuleName()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_ModuleName();

		/**
	 * Returns the meta object for the reference list '{@link org.eclipse.camf.infosystem.model.base.Module#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instances</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Module#getInstances()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Instances();

		/**
	 * Returns the meta object for the attribute '{@link org.eclipse.camf.infosystem.model.base.Module#getInitInstances <em>Init Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Init Instances</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.Module#getInitInstances()
	 * @see #getModule()
	 * @generated
	 */
	EAttribute getModule_InitInstances();

		/**
	 * Returns the meta object for enum '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageType <em>Virtual Machine Image Type</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Virtual Machine Image Type</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageType
	 * @generated
	 */
  EEnum getVirtualMachineImageType();

  /**
	 * Returns the meta object for data type '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageType <em>Virtual Machine Image Type Object</em>}'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Virtual Machine Image Type Object</em>'.
	 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageType
	 * @model instanceClass="org.eclipse.camf.infosystem.model.base.VirtualMachineImageType"
	 *        extendedMetaData="name='VirtualMachineImageType:Object' baseType='VirtualMachineImageType'"
	 * @generated
	 */
  EDataType getVirtualMachineImageTypeObject();

  /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
  InfoSystemFactory getInfoSystemFactory();

  /**
	 * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
	 * @generated
	 */
  interface Literals
  {
    /**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.MonitoringProbeImpl <em>Monitoring Probe</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.MonitoringProbeImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getMonitoringProbe()
		 * @generated
		 */
    EClass MONITORING_PROBE = eINSTANCE.getMonitoringProbe();

    /**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute MONITORING_PROBE__UID = eINSTANCE.getMonitoringProbe_UID();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute MONITORING_PROBE__NAME = eINSTANCE.getMonitoringProbe_Name();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute MONITORING_PROBE__DESCRIPTION = eINSTANCE.getMonitoringProbe_Description();

    /**
		 * The meta object literal for the '<em><b>Metrics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MONITORING_PROBE__METRICS = eINSTANCE.getMonitoringProbe_Metrics();

				/**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.ResizingActionImpl <em>Resizing Action</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.ResizingActionImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getResizingAction()
		 * @generated
		 */
    EClass RESIZING_ACTION = eINSTANCE.getResizingAction();

    /**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute RESIZING_ACTION__UID = eINSTANCE.getResizingAction_UID();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute RESIZING_ACTION__NAME = eINSTANCE.getResizingAction_Name();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute RESIZING_ACTION__DESCRIPTION = eINSTANCE.getResizingAction_Description();

    /**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute RESIZING_ACTION__URL = eINSTANCE.getResizingAction_URL();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.SoftwareDependencyImpl <em>Software Dependency</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.SoftwareDependencyImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getSoftwareDependency()
		 * @generated
		 */
    EClass SOFTWARE_DEPENDENCY = eINSTANCE.getSoftwareDependency();

    /**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SOFTWARE_DEPENDENCY__UID = eINSTANCE.getSoftwareDependency_UID();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SOFTWARE_DEPENDENCY__NAME = eINSTANCE.getSoftwareDependency_Name();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SOFTWARE_DEPENDENCY__DESCRIPTION = eINSTANCE.getSoftwareDependency_Description();

    /**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SOFTWARE_DEPENDENCY__URL = eINSTANCE.getSoftwareDependency_URL();

    /**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute SOFTWARE_DEPENDENCY__TYPE = eINSTANCE.getSoftwareDependency_Type();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageImpl <em>Virtual Machine Image</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImage()
		 * @generated
		 */
    EClass VIRTUAL_MACHINE_IMAGE = eINSTANCE.getVirtualMachineImage();

    /**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIRTUAL_MACHINE_IMAGE__UID = eINSTANCE.getVirtualMachineImage_UID();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIRTUAL_MACHINE_IMAGE__NAME = eINSTANCE.getVirtualMachineImage_Name();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIRTUAL_MACHINE_IMAGE__DESCRIPTION = eINSTANCE.getVirtualMachineImage_Description();

    /**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIRTUAL_MACHINE_IMAGE__TYPE = eINSTANCE.getVirtualMachineImage_Type();

    /**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIRTUAL_MACHINE_IMAGE__URL = eINSTANCE.getVirtualMachineImage_URL();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.UserApplicationImpl <em>User Application</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.UserApplicationImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getUserApplication()
		 * @generated
		 */
    EClass USER_APPLICATION = eINSTANCE.getUserApplication();

    /**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER_APPLICATION__UID = eINSTANCE.getUserApplication_UID();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER_APPLICATION__NAME = eINSTANCE.getUserApplication_Name();

    /**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER_APPLICATION__DESCRIPTION = eINSTANCE.getUserApplication_Description();

    /**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER_APPLICATION__URL = eINSTANCE.getUserApplication_URL();

    /**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute USER_APPLICATION__TYPE = eINSTANCE.getUserApplication_Type();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.KeyPairImpl <em>Key Pair</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.KeyPairImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getKeyPair()
		 * @generated
		 */
    EClass KEY_PAIR = eINSTANCE.getKeyPair();

    /**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute KEY_PAIR__UID = eINSTANCE.getKeyPair_UID();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute KEY_PAIR__NAME = eINSTANCE.getKeyPair_Name();

    /**
		 * The meta object literal for the '<em><b>Public Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_PAIR__PUBLIC_KEY = eINSTANCE.getKeyPair_PublicKey();

				/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_PAIR__DESCRIPTION = eINSTANCE.getKeyPair_Description();

				/**
		 * The meta object literal for the '<em><b>URL</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute KEY_PAIR__URL = eINSTANCE.getKeyPair_URL();

				/**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageFlavorImpl <em>Virtual Machine Image Flavor</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.VirtualMachineImageFlavorImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageFlavor()
		 * @generated
		 */
    EClass VIRTUAL_MACHINE_IMAGE_FLAVOR = eINSTANCE.getVirtualMachineImageFlavor();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIRTUAL_MACHINE_IMAGE_FLAVOR__NAME = eINSTANCE.getVirtualMachineImageFlavor_Name();

    /**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIRTUAL_MACHINE_IMAGE_FLAVOR__UID = eINSTANCE.getVirtualMachineImageFlavor_UID();

    /**
		 * The meta object literal for the '<em><b>Ram</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_MACHINE_IMAGE_FLAVOR__RAM = eINSTANCE.getVirtualMachineImageFlavor_Ram();

				/**
		 * The meta object literal for the '<em><b>Hdd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_MACHINE_IMAGE_FLAVOR__HDD = eINSTANCE.getVirtualMachineImageFlavor_Hdd();

				/**
		 * The meta object literal for the '<em><b>VCPU</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_MACHINE_IMAGE_FLAVOR__VCPU = eINSTANCE.getVirtualMachineImageFlavor_VCPU();

				/**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.VirtualNetworkImpl <em>Virtual Network</em>}' class.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.VirtualNetworkImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualNetwork()
		 * @generated
		 */
    EClass VIRTUAL_NETWORK = eINSTANCE.getVirtualNetwork();

    /**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIRTUAL_NETWORK__UID = eINSTANCE.getVirtualNetwork_UID();

    /**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @generated
		 */
    EAttribute VIRTUAL_NETWORK__NAME = eINSTANCE.getVirtualNetwork_Name();

    /**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.VirtualInstanceImpl <em>Virtual Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.VirtualInstanceImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualInstance()
		 * @generated
		 */
		EClass VIRTUAL_INSTANCE = eINSTANCE.getVirtualInstance();

				/**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_INSTANCE__UID = eINSTANCE.getVirtualInstance_UID();

				/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_INSTANCE__NAME = eINSTANCE.getVirtualInstance_Name();

				/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_INSTANCE__STATUS = eINSTANCE.getVirtualInstance_Status();

				/**
		 * The meta object literal for the '<em><b>IPs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_INSTANCE__IPS = eINSTANCE.getVirtualInstance_IPs();

				/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VIRTUAL_INSTANCE__URI = eINSTANCE.getVirtualInstance_URI();

				/**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.SecurityGroupImpl <em>Security Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.SecurityGroupImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getSecurityGroup()
		 * @generated
		 */
		EClass SECURITY_GROUP = eINSTANCE.getSecurityGroup();

				/**
		 * The meta object literal for the '<em><b>UID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_GROUP__UID = eINSTANCE.getSecurityGroup_UID();

				/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_GROUP__NAME = eINSTANCE.getSecurityGroup_Name();

				/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECURITY_GROUP__DESCRIPTION = eINSTANCE.getSecurityGroup_Description();

				/**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.DeploymentImpl <em>Deployment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.DeploymentImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getDeployment()
		 * @generated
		 */
		EClass DEPLOYMENT = eINSTANCE.getDeployment();

				/**
		 * The meta object literal for the '<em><b>Dep ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT__DEP_ID = eINSTANCE.getDeployment_DepID();

				/**
		 * The meta object literal for the '<em><b>Deployment Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT__DEPLOYMENT_NAME = eINSTANCE.getDeployment_DeploymentName();

				/**
		 * The meta object literal for the '<em><b>Modules</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT__MODULES = eINSTANCE.getDeployment_Modules();

				/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPLOYMENT__STATUS = eINSTANCE.getDeployment_Status();

				/**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.impl.ModuleImpl
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

				/**
		 * The meta object literal for the '<em><b>Mod ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__MOD_ID = eINSTANCE.getModule_ModID();

				/**
		 * The meta object literal for the '<em><b>Module Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__MODULE_NAME = eINSTANCE.getModule_ModuleName();

				/**
		 * The meta object literal for the '<em><b>Instances</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__INSTANCES = eINSTANCE.getModule_Instances();

				/**
		 * The meta object literal for the '<em><b>Init Instances</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODULE__INIT_INSTANCES = eINSTANCE.getModule_InitInstances();

				/**
		 * The meta object literal for the '{@link org.eclipse.camf.infosystem.model.base.VirtualMachineImageType <em>Virtual Machine Image Type</em>}' enum.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageType
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageType()
		 * @generated
		 */
    EEnum VIRTUAL_MACHINE_IMAGE_TYPE = eINSTANCE.getVirtualMachineImageType();

    /**
		 * The meta object literal for the '<em>Virtual Machine Image Type Object</em>' data type.
		 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
		 * @see org.eclipse.camf.infosystem.model.base.VirtualMachineImageType
		 * @see org.eclipse.camf.infosystem.model.base.impl.InfoSystemPackageImpl#getVirtualMachineImageTypeObject()
		 * @generated
		 */
    EDataType VIRTUAL_MACHINE_IMAGE_TYPE_OBJECT = eINSTANCE.getVirtualMachineImageTypeObject();

  }

} //InfoSystemPackage
