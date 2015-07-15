/************************************************************
 * Copyright (C), 2013 CELAR Consortium 
 * http://www.celarcloud.eu
 * 
 * Contributors:
 *      Stalo Sofokleous - initial API and implementation
 ************************************************************/
package org.eclipse.camf.tosca.editor.property;

import java.math.BigInteger;

import org.eclipse.camf.tosca.PoliciesType;
import org.eclipse.camf.tosca.TDeploymentArtifact;
import org.eclipse.camf.tosca.TPolicy;
import org.eclipse.camf.tosca.ToscaFactory;
import org.eclipse.camf.tosca.elasticity.TNodeTemplateExtension;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.xml.type.internal.QName;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * Application Component Properties - Smart Deployment Tab
 */
public class ApplicationComponentSmartSection extends GFPropertySection
		implements ITabbedPropertyConstants, ModifyListener {

	Section sectionDH;
	Section sectionLH;
	Text minCpuText, maxCpuText, minRamText, maxRamText, minDiskText,
			maxDiskText;

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		// Application Component Data Hints Section
		Section section = toolkit.createSection(parent, Section.TITLE_BAR);
		section.setText("System-Level Requirements"); //$NON-NLS-1$
		Composite client = toolkit.createComposite(section, SWT.WRAP);
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
		layout.marginTop = 15;
		layout.verticalSpacing = 15;
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		client.setLayout(layout);

		GridData gd;
		gd = new GridData();
		CLabel valueLabel1 = factory.createCLabel(client, ""); //$NON-NLS-1$
		CLabel valueLabel2 = factory.createCLabel(client, "Min"); //$NON-NLS-1$
		CLabel valueLabel3 = factory.createCLabel(client, "Max"); //$NON-NLS-1$
		CLabel valueLabel4 = factory.createCLabel(client, "Unit"); //$NON-NLS-1$
		valueLabel1.setLayoutData(gd);
		valueLabel2.setLayoutData(gd);
		valueLabel3.setLayoutData(gd);
		valueLabel4.setLayoutData(gd);
		toolkit.adapt(valueLabel1, true, true);
		toolkit.adapt(valueLabel2, true, true);
		toolkit.adapt(valueLabel3, true, true);
		toolkit.adapt(valueLabel4, true, true);

		CLabel cpuLabel = factory.createCLabel(client, "CPU:"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
		gd.widthHint = 60;
		cpuLabel.setLayoutData(gd);
		// Minimun num of cpus text
		this.minCpuText = factory.createText(client, ""); //$NON-NLS-1$
		this.minCpuText.setEditable(true);
		this.minCpuText.addModifyListener(this);
	    gd = new GridData();
	    gd.widthHint = 120;
	    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
	    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
	    this.minCpuText.setLayoutData(gd);

		// Maximum num of cpus text
		this.maxCpuText = factory.createText(client, ""); //$NON-NLS-1$
		this.maxCpuText.setEditable(true);
		this.maxCpuText.addModifyListener(this);
	    gd = new GridData();
	    gd.widthHint = 120;
	    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
	    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
	    this.maxCpuText.setLayoutData(gd);

		CLabel coresLabel = factory.createCLabel(client, "vCores"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
		gd.widthHint = 60;
		coresLabel.setLayoutData(gd);

		// Add section components to the toolkit
		toolkit.adapt(cpuLabel, true, true);
		toolkit.adapt(this.minCpuText, true, true);
		toolkit.adapt(this.maxCpuText, true, true);
		toolkit.adapt(coresLabel, true, true);

		// RAM
		CLabel ramLabel = factory.createCLabel(client, "RAM:"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
		gd.widthHint = 60;
		ramLabel.setLayoutData(gd);
		// Minimun num of RAM text
		this.minRamText = factory.createText(client, ""); //$NON-NLS-1$
		this.minRamText.setEditable(true);
		this.minRamText.addModifyListener(this);
	    gd = new GridData();
	    gd.widthHint = 120;
	    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
	    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
	    this.minRamText.setLayoutData(gd);

		// Maximum num of RAM text
		this.maxRamText = factory.createText(client, ""); //$NON-NLS-1$
		this.maxRamText.setEditable(true);
		this.maxRamText.addModifyListener(this);
	    gd = new GridData();
	    gd.widthHint = 120;
	    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
	    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
	    this.maxRamText.setLayoutData(gd);

		CLabel mbLabel = factory.createCLabel(client, "MB"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
		gd.widthHint = 60;
		mbLabel.setLayoutData(gd);

		// Add section components to the toolkit
		toolkit.adapt(ramLabel, true, true);
		toolkit.adapt(this.minRamText, true, true);
		toolkit.adapt(this.maxRamText, true, true);
		toolkit.adapt(mbLabel, true, true);

		// DISK
		CLabel diskLabel = factory.createCLabel(client, "DISK:"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
		gd.widthHint = 60;
		diskLabel.setLayoutData(gd);
		// Minimun num of disk text
		this.minDiskText = factory.createText(client, ""); //$NON-NLS-1$
		this.minDiskText.setEditable(true);
		this.minDiskText.addModifyListener(this);
	    gd = new GridData();
	    gd.widthHint = 120;
	    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
	    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
	    this.minDiskText.setLayoutData(gd);

		// Maximum num of disk text
		this.maxDiskText = factory.createText(client, ""); //$NON-NLS-1$
		this.maxDiskText.setEditable(true);
		this.maxDiskText.addModifyListener(this);
	    gd = new GridData();
	    gd.widthHint = 120;
	    gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
	    gd.verticalAlignment = GridData.VERTICAL_ALIGN_BEGINNING;
	    this.maxDiskText.setLayoutData(gd);

		CLabel gbLabel = factory.createCLabel(client, "GB"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gd.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
		gd.widthHint = 60;
		gbLabel.setLayoutData(gd);

		// Add section components to the toolkit
		toolkit.adapt(diskLabel, true, true);
		toolkit.adapt(this.minDiskText, true, true);
		toolkit.adapt(this.maxDiskText, true, true);
		toolkit.adapt(gbLabel, true, true);

		section.setClient(client);

	}

	/*
	 * Refresh Tab(non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		String minCpu="", maxCpu="", minRam="", maxRam="", minDisk="", maxDisk="";
		PictogramElement pe = getSelectedPictogramElement();
		TNodeTemplateExtension nodeTemplate = null;
		if (pe != null) {
			final Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a TNodeTemplate
			if (bo == null)
				return;
			
			if (bo instanceof TDeploymentArtifact) {
				PictogramElement parentPE = Graphiti.getPeService()
						.getPictogramElementParent(pe);
				nodeTemplate = (TNodeTemplateExtension) Graphiti
						.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(parentPE);
			} else { // bo instanceof TNodeTemplate
				nodeTemplate = (TNodeTemplateExtension) bo;
			}
		}
		if (nodeTemplate.getPolicies()!=null && nodeTemplate.getPolicies().getPolicy()!=null){

			for (final TPolicy tempPolicy : nodeTemplate.getPolicies()
					.getPolicy()) {
				if (tempPolicy.getName().contains("sys:cpu")) {
					String cpuValue = tempPolicy.getName();
					if (cpuValue.contains("-")){
						minCpu = cpuValue.substring(cpuValue.indexOf("[")+1, cpuValue.indexOf("-"));
						maxCpu = cpuValue.substring(cpuValue.indexOf("-")+1, cpuValue.length()-1);
					}
					else{
						minCpu=cpuValue.substring(cpuValue.indexOf("=")+1, cpuValue.length());
					}

				}
				else if (tempPolicy.getName().contains("sys:ram")) {
					String ramValue = tempPolicy.getName();
					if (ramValue.contains("-")){
						minRam = ramValue.substring(ramValue.indexOf("[")+1, ramValue.indexOf("-"));
						maxRam = ramValue.substring(ramValue.indexOf("-")+1, ramValue.length()-1);
					}
					else{
						minRam=ramValue.substring(ramValue.indexOf("=")+1, ramValue.length());;
					}

				}
				else if (tempPolicy.getName().contains("sys:disk")) {
					String diskValue = tempPolicy.getName();
					if (diskValue.contains("-")){
						minDisk = diskValue.substring(diskValue.indexOf("[")+1, diskValue.indexOf("-"));
						maxDisk = diskValue.substring(diskValue.indexOf("-")+1, diskValue.length()-1);
					}
					else{
						minDisk=diskValue.substring(diskValue.indexOf("=")+1, diskValue.length());;
					}

				}
			}
		}
		this.minCpuText.setText(minCpu);
		this.maxCpuText.setText(maxCpu);
		this.minRamText.setText(minRam);
		this.maxRamText.setText(maxRam);
		this.minDiskText.setText(minDisk);
		this.maxDiskText.setText(maxDisk);
	}

	@Override
	public void modifyText(final ModifyEvent e) {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			final Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a TNodeTemplate
			if (bo == null)
				return;
			final TNodeTemplateExtension nodeTemplate;
			if (bo instanceof TDeploymentArtifact) {
				PictogramElement parentPE = Graphiti.getPeService()
						.getPictogramElementParent(pe);
				nodeTemplate = (TNodeTemplateExtension) Graphiti
						.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(parentPE);
			} else { // bo instanceof TNodeTemplate
				nodeTemplate = (TNodeTemplateExtension) bo;
			}
			// minCpuText/maxCpuText Listener
			if (e.widget == this.minCpuText || e.widget == this.maxCpuText) {
				if (this.minCpuText.getText()!=""){
					String policyValue = "sys:cpu=";
					if (this.maxCpuText.getText() != "") {
						policyValue += "[" + this.minCpuText.getText() + "-"
								+ this.maxCpuText.getText() + "]";
					} else {
						policyValue += this.minCpuText.getText();
					}
					boolean policyExists = false;
					if (nodeTemplate.getPolicies() == null) {
						final PoliciesType nodePolicyList = ToscaFactory.eINSTANCE
								.createPoliciesType();
						TransactionalEditingDomain editingDomain = TransactionUtil
								.getEditingDomain(bo);
						editingDomain.getCommandStack().execute(
								new RecordingCommand(editingDomain) {

									@Override
									protected void doExecute() {
										nodeTemplate.setPolicies(nodePolicyList);
									}
								});
					} else {
						for (final TPolicy tempPolicy : nodeTemplate.getPolicies()
								.getPolicy()) {
							if (tempPolicy.getName().contains("sys:cpu")) {
								final String newPolicyValue = policyValue;
								TransactionalEditingDomain editingDomain = TransactionUtil
										.getEditingDomain(bo);
								editingDomain.getCommandStack().execute(
										new RecordingCommand(editingDomain) {

											@Override
											protected void doExecute() {
												tempPolicy.setName(newPolicyValue);
											}
										});

								policyExists = true;
							}
						}
					}
					if (!policyExists) {
						PoliciesType nodePolicyList = nodeTemplate.getPolicies();
						final EList<TPolicy> policy = nodePolicyList.getPolicy();
						final TPolicy newPolicy = ToscaFactory.eINSTANCE
								.createTPolicy();
						String type = "Requirement";
						QName policyTypeName = new QName(
								"http://www.example.org/SmartDeployment", type,
								null);

						newPolicy.setPolicyType(policyTypeName);
						newPolicy.setName(type.toUpperCase() + " " + policyValue);

						String id = "R"
								+ ((Integer) nodeTemplate.hashCode()).toString()
								+ nodePolicyList.getPolicy().size();
						QName qnamePolicyTemplate = new QName(id);
						newPolicy.setPolicyRef(qnamePolicyTemplate);

						TransactionalEditingDomain editingDomain = TransactionUtil
								.getEditingDomain(bo);
						editingDomain.getCommandStack().execute(
								new RecordingCommand(editingDomain) {

									@Override
									protected void doExecute() {
										policy.add(newPolicy);
									}
								});
					}	
				}
			}
			// minDiskText/maxDiskText Listener
			else if (e.widget == this.minDiskText
					|| e.widget == this.maxDiskText) {
				if (this.minDiskText.getText()!=""){
					String policyValue = "sys:disk=";
					if (this.maxDiskText.getText() != "") {
						policyValue += "[" + this.minDiskText.getText() + "-"
								+ this.maxDiskText.getText() + "]";
					} else {
						policyValue += this.minDiskText.getText();
					}
					boolean policyExists = false;
					if (nodeTemplate.getPolicies() == null) {
						final PoliciesType nodePolicyList = ToscaFactory.eINSTANCE
								.createPoliciesType();
						TransactionalEditingDomain editingDomain = TransactionUtil
								.getEditingDomain(bo);
						editingDomain.getCommandStack().execute(
								new RecordingCommand(editingDomain) {

									@Override
									protected void doExecute() {
										nodeTemplate.setPolicies(nodePolicyList);
									}
								});
					} else {
						for (final TPolicy tempPolicy : nodeTemplate.getPolicies()
								.getPolicy()) {
							if (tempPolicy.getName().contains("sys:disk")) {
								final String newPolicyValue = policyValue;
								TransactionalEditingDomain editingDomain = TransactionUtil
										.getEditingDomain(bo);
								editingDomain.getCommandStack().execute(
										new RecordingCommand(editingDomain) {

											@Override
											protected void doExecute() {
												tempPolicy.setName(newPolicyValue);
											}
										});

								policyExists = true;
							}
						}
					}
					if (!policyExists) {
						PoliciesType nodePolicyList = nodeTemplate.getPolicies();
						final EList<TPolicy> policy = nodePolicyList.getPolicy();
						final TPolicy newPolicy = ToscaFactory.eINSTANCE
								.createTPolicy();
						String type = "Requirement";
						QName policyTypeName = new QName(
								"http://www.example.org/SmartDeployment", type,
								null);

						newPolicy.setPolicyType(policyTypeName);
						newPolicy.setName(type.toUpperCase() + " " + policyValue);

						String id = "R"
								+ ((Integer) nodeTemplate.hashCode()).toString()
								+ nodePolicyList.getPolicy().size();
						QName qnamePolicyTemplate = new QName(id);
						newPolicy.setPolicyRef(qnamePolicyTemplate);

						TransactionalEditingDomain editingDomain = TransactionUtil
								.getEditingDomain(bo);
						editingDomain.getCommandStack().execute(
								new RecordingCommand(editingDomain) {

									@Override
									protected void doExecute() {
										policy.add(newPolicy);
									}
								});
					}
				}

			}
			// minRamText/maxRamText Listener
			else if (e.widget == this.minRamText || e.widget == this.maxRamText) {
				if (this.minRamText.getText()!=""){
					String policyValue = "sys:ram=";
					if (this.maxRamText.getText() != "") {
						policyValue += "[" + this.minRamText.getText() + "-"
								+ this.maxRamText.getText() + "]";
					} else {
						policyValue += this.minRamText.getText();
					}
					boolean policyExists = false;
					if (nodeTemplate.getPolicies() == null) {
						final PoliciesType nodePolicyList = ToscaFactory.eINSTANCE
								.createPoliciesType();
						TransactionalEditingDomain editingDomain = TransactionUtil
								.getEditingDomain(bo);
						editingDomain.getCommandStack().execute(
								new RecordingCommand(editingDomain) {

									@Override
									protected void doExecute() {
										nodeTemplate.setPolicies(nodePolicyList);
									}
								});
					} else {
						for (final TPolicy tempPolicy : nodeTemplate.getPolicies()
								.getPolicy()) {
							if (tempPolicy.getName().contains("sys:ram")) {
								final String newPolicyValue = policyValue;
								TransactionalEditingDomain editingDomain = TransactionUtil
										.getEditingDomain(bo);
								editingDomain.getCommandStack().execute(
										new RecordingCommand(editingDomain) {

											@Override
											protected void doExecute() {
												tempPolicy.setName(newPolicyValue);
											}
										});

								policyExists = true;
							}
						}
					}
					if (!policyExists) {
						PoliciesType nodePolicyList = nodeTemplate.getPolicies();
						final EList<TPolicy> policy = nodePolicyList.getPolicy();
						final TPolicy newPolicy = ToscaFactory.eINSTANCE
								.createTPolicy();
						String type = "Requirement";
						QName policyTypeName = new QName(
								"http://www.example.org/SmartDeployment", type,
								null);

						newPolicy.setPolicyType(policyTypeName);
						newPolicy.setName(type.toUpperCase() + " " + policyValue);

						String id = "R"
								+ ((Integer) nodeTemplate.hashCode()).toString()
								+ nodePolicyList.getPolicy().size();
						QName qnamePolicyTemplate = new QName(id);
						newPolicy.setPolicyRef(qnamePolicyTemplate);

						TransactionalEditingDomain editingDomain = TransactionUtil
								.getEditingDomain(bo);
						editingDomain.getCommandStack().execute(
								new RecordingCommand(editingDomain) {

									@Override
									protected void doExecute() {
										policy.add(newPolicy);
									}
								});
					}
				}

			}
		}
	}

}
