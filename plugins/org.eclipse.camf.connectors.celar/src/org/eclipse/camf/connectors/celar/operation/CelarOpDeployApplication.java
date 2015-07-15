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
 * 	Stalo Sofokleous - initial API and implementation
 *******************************************************************************/
package org.eclipse.camf.connectors.celar.operation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.mime.MultipartEntity;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;

import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import org.eclipse.camf.core.Preferences;
import org.eclipse.camf.core.model.impl.GenericCloudProvider;
import org.eclipse.camf.core.model.CloudModel;
import org.eclipse.camf.core.model.ICloudDeploymentService;
import org.eclipse.camf.core.model.ICloudElement;
import org.eclipse.camf.core.model.ICloudProject;
import org.eclipse.camf.core.model.ICloudProvider;
import org.eclipse.camf.core.model.ICloudProviderManager;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.camf.tosca.DocumentRoot;
import org.eclipse.camf.tosca.core.TOSCAModel;
import org.eclipse.camf.tosca.core.TOSCAResource;
import org.eclipse.camf.tosca.editor.ToscaDiagramEditor;
import org.eclipse.camf.tosca.elasticity.ServicePropertiesType;

import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Main class that gathers the necessary elements from the TOSCA description and
 * makes the deployment to the OpenStack provider
 */
public class CelarOpDeployApplication extends AbstractCelarOpDeployApplication {

	private final TOSCAResource toscaResource;
	private final ICloudProject project;

	private TOSCAModel toscaModel;
	private File csar;
	private IFile deploymentIFile;
	private ArrayList<String> zipEntries = new ArrayList<String>();
	private ArrayList<String> selectedProvidersNames = new ArrayList<String>();
	private ArrayList<ICloudProvider> selectedProviders = new ArrayList<ICloudProvider>();

	public CelarOpDeployApplication(final TOSCAResource tosca) {
		this.toscaResource = tosca;
		this.project = this.toscaResource.getProject();

		this.toscaModel = this.toscaResource.getTOSCAModel();
		IResource resourceName = this.toscaResource.getResource();
		this.deploymentIFile = (IFile) resourceName;
		
	    ServicePropertiesType serviceProperties = ( ServicePropertiesType )this.toscaModel.getDocumentRoot()
	    	      .getDefinitions()
	    	      .getServiceTemplate()
	    	      .get( 0 )
	    	      .getBoundaryDefinitions()
	    	      .getProperties()
	    	      .getAny()
	    	      .get( 0 )
	    	      .getValue();
	    	    for( String providerName : serviceProperties.getHostingEnvironment() ) {
	    	      this.selectedProvidersNames.add( providerName );
	    	    }
	    	    // final ICloudProviderManager manager =
	    	    // CloudModel.getCloudProviderManager();
	    	    ICloudElement[] providers = null;
	    	    providers = Preferences.getDefinedCloudProviders();
	    	    // try {
	    	    // providers = manager.getChildren( null );
	    	    // } catch( ProblemException e ) {
	    	    // // TODO Auto-generated catch block
	    	    // e.printStackTrace();
	    	    // }
	    	    for( String providerName : this.selectedProvidersNames ) {
	    	      for( ICloudElement provider : providers ) {
	    	        if( providerName.compareTo( ( ( ICloudProvider )provider ).getName() ) == 0 )
	    	        {
	    	          this.selectedProviders.add( ( ICloudProvider )provider );
	    	        }
	    	      }
	    	    }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.camf.connectors.celar.operation.AbstractCelarOpDeployApplication
	 * #run()
	 */

	@Override
	public void run() {
		setResult(null);
		setException(null);
		try {
			// set Start time of the deployment
			String start_time = new SimpleDateFormat("dd/M/yyyy hh:mm:ss")
					.format(Calendar.getInstance().getTime());

		} catch (Exception ex) {
			this.setException(ex);
			ex.printStackTrace();
		}
	    // Export CSAR file
	    try {
	      exportCSAR();
	    } catch( IOException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    } catch( CoreException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	    openISbrowser();
	    MessageConsole myConsole = findConsole( "MyConsole" );
	    MessageConsoleStream out = myConsole.newMessageStream();
	    out.println( "Starting deployment procedure..." );
	    for( ICloudProvider selectedProvider : this.selectedProviders ) {
	      GenericCloudProvider provider = ( GenericCloudProvider )selectedProvider;
	      String uri = provider.getUri();
	      if( uri != null ) {
	        if( uri.endsWith( "/" ) ) {
	          uri = uri.substring( 0, uri.length() - 1 );
	        }
	      } else {
	        continue;
	      }
	      String port = provider.getPort();
	      if( port != null ) {
	        if( port.endsWith( "/" ) ) {
	          port = port.substring( 0, port.length() - 1 );
	        }
	        uri = uri + ":" + port;
	      }
	      String applicationId = describeApplication( uri );
	      // String applicationId = describeApplicationHttps(uri);
	      String deploymentId = null;
	      if( applicationId != null ) {
	        deploymentId = deployApplication( uri, applicationId );
	        // deploymentId = deployApplicationHttps(uri, applicationId);
	      }
	      if( deploymentId != null ) {
	        // getDeploymentState(uri, deploymentId);
	        // terminateDeployment(uri, deploymentId);
	      }
	    }
	}

	public Object getResult() {
		return null;
	}

	public void exportCSAR() throws IOException, CoreException {
		// Export monitoring probes to jar files
		// IWorkspaceRoot workspaceRoot =
		// ResourcesPlugin.getWorkspace().getRoot();
		// IProject monitoringProbesProject = workspaceRoot.getProject(
		// "MonitoringProbe" );
		// IFolder srcFolder = monitoringProbesProject.getFolder( "src" );
		// IResource[] monitoringProbes = srcFolder.members();
		// for( IResource monitoringProbeFile : monitoringProbes )
		// exportProbe( ( IFile )monitoringProbeFile );

		// Create CSAR
		String csarName = this.toscaResource.getName();
		this.csar = new File(
				System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop" + System.getProperty("file.separator") + csarName.replace("tosca", "csar")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		FileOutputStream fos = new FileOutputStream(csar);
		ZipOutputStream zos = new ZipOutputStream(fos);
		// File names
		String metaFile = "TOSCA.meta"; //$NON-NLS-1$
		String defFileName = "Application.tosca"; //$NON-NLS-1$
		String keyFileName = "celar.pub"; //$NON-NLS-1$
		// Create dummy TOSCA meta
		addToCSARFile(
				"TOSCA-Metadata", metaFile, getMetaContent(defFileName), zos); //$NON-NLS-1$
		// Create Valid TOSCA
		// DocumentRoot toscaDescription = toscaModel.getDocumentRoot();
		//    addToCSARFile( "Definitions", defFileName, convertToXml( toscaDescription ), zos ); //$NON-NLS-1$
		addToCSARFile(
				"Definitions", defFileName, getFileContents(this.deploymentIFile), zos); //$NON-NLS-1$
		// Create a dummy SSH public key-pair file
		addToCSARFile("Keys", keyFileName, getKeyPair(), zos); //$NON-NLS-1$   
		IProject activeProject = null;

		ICloudProject cloudProject = this.toscaResource.getProject();
		activeProject = (IProject) cloudProject.getResource();

		// IProject activeProject = ToscaDiagramEditor.getActiveProject();
		IFolder scriptsFolder = activeProject
				.getFolder(new Path(
						System.getProperty("file.separator") + "Artifacts" + System.getProperty("file.separator") + "Deployment Scripts")); //$NON-NLS-1$ //$NON-NLS-2$
		IResource[] scriptFiles = scriptsFolder.members();
		for (IResource resource : scriptFiles) {
			IFile tempFile = (IFile) resource;
			String fileName = tempFile.getName();
			if (this.zipEntries.contains(fileName)) {
				System.out.println("zip entry exists");
			} else {
				this.zipEntries.add(fileName);
				String content = getFileContents(tempFile);
				addToCSARFile("Scripts", fileName, content, zos); //$NON-NLS-1$
			}
		}
		IFolder resizingScriptsFolder = activeProject
				.getFolder(new Path(
						System.getProperty("file.separator") + "Artifacts" + System.getProperty("file.separator") + "Reconfiguration Scripts")); //$NON-NLS-1$ //$NON-NLS-2$
		scriptFiles = resizingScriptsFolder.members();
		for (IResource resource : scriptFiles) {
			IFile tempFile = (IFile) resource;
			String fileName = tempFile.getName();
			if (this.zipEntries.contains(fileName)) {
				System.out.println("zip entry exists");
			} else {
				String content = getFileContents(tempFile);
				addToCSARFile("Scripts", fileName, content, zos); //$NON-NLS-1$
			}
		}
		addToCSARFile(
				"TUW",
				"CompositionRules",
				getFileFromGit(
						"https://raw.githubusercontent.com/CELAR/c-Eclipse/master/pom.xml",
						"pom.xml"), zos);
		zos.close();
		fos.close();
	}

	private static String getFileContents(IFile file) {
		InputStream in = null;
		try {
			in = file.getContents();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader is = new InputStreamReader(in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(is);
		String read;
		try {
			read = br.readLine();
			while (read != null) {
				sb.append(read);
				sb.append(System.getProperty("line.separator"));
				read = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	private static String getKeyPair() {
		return "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAAAgQCn3TzXwzRDtoPRUyRm784Wwa61EhhEd7rvr9qrLVjNvvCv/JP80sgE43LzxlEx7uiHEbzhhQdVHvTozTA2WEzyhVfYEhDhqt5xVl2Xf0skbAc3qLP42hguYXZ7NPtCUEUbQqN0Oo4WafUo4sRG+FNIu+nO66DbZEcmRBv3YYtcOw== AWS-RSA-1024"; //$NON-NLS-1$
	}

	void exportProbe(IFile file) throws IOException {
		IProject activeProject = ToscaDiagramEditor.getActiveProject();
		IFolder monitoringFolder = activeProject.getFolder("Monitoring"); //$NON-NLS-1$
		IPath jarFilePath = monitoringFolder.getRawLocation()
				.append(file.getName()).removeFileExtension()
				.addFileExtension("jar"); //$NON-NLS-1$
		byte buffer[] = new byte[10240];
		// Open archive file
		FileOutputStream stream = new FileOutputStream(jarFilePath.toString());
		JarOutputStream out = new JarOutputStream(stream, new Manifest());
		// Add probe file archive entry
		JarEntry jarAdd = new JarEntry(file.getName());
		out.putNextEntry(jarAdd);
		// Write file to archive
		FileInputStream in = new FileInputStream(file.getRawLocation()
				.toString());
		while (true) {
			int nRead = in.read(buffer, 0, buffer.length);
			if (nRead <= 0)
				break;
			out.write(buffer, 0, nRead);
		}
		in.close();
		out.closeEntry();
		// Add ProbePack.jar file archive entry
		jarAdd = new JarEntry("ProbePack.jar"); //$NON-NLS-1$
		out.putNextEntry(jarAdd);
		// Write file to archive
		in = new FileInputStream(
				"C:\\Users\\stalo.cs8526\\Desktop\\ProbePack.jar"); //$NON-NLS-1$
		while (true) {
			int nRead = in.read(buffer, 0, buffer.length);
			if (nRead <= 0)
				break;
			out.write(buffer, 0, nRead);
		}
		in.close();
		out.closeEntry();
		out.close();
		stream.close();
		// Refresh Cloud Model
		IProgressMonitor monitor = null;
		try {
			CloudModel.getRoot().refresh(monitor);
		} catch (ProblemException e2) {
			e2.printStackTrace();
		}
	}

	private boolean isRedirected(Map<String, List<String>> header) {
		for (String hv : header.get(null)) {
			if (hv.contains(" 301 ") || hv.contains(" 302 "))
				return true;
		}
		return false;
	}

	private String getFileFromGit(String link, String fileName)
			throws IOException {
		URL url = new URL(link);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		Map<String, List<String>> header = http.getHeaderFields();
		while (isRedirected(header)) {
			link = header.get("Location").get(0);
			url = new URL(link);
			http = (HttpURLConnection) url.openConnection();
			header = http.getHeaderFields();
		}
		InputStream input = http.getInputStream();
		String fileContents = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(input));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			fileContents = fileContents + inputLine
					+ System.getProperty("line.separator");
			// System.out.println(inputLine);
		}
		in.close();
		return fileContents;
	}

	/**
	 * @param dir
	 * @param fileName
	 * @param content
	 * @param zos
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void addToCSARFile(final String dir, final String fileName,
			final String content, final ZipOutputStream zos)
			throws FileNotFoundException, IOException {
		String tmpDir = System.getProperty("java.io.tmpdir") + System.getProperty("file.separator"); //$NON-NLS-1$
		File file = new File(tmpDir + fileName);
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		byte[] contentInBytes = content.getBytes();
		fos.write(contentInBytes);
		fos.flush();
		fos.close();
		FileInputStream fis = new FileInputStream(file);
		// ZipEntry zipEntry = new ZipEntry( dir + "/" + fileName );
		ZipEntry zipEntry = new ZipEntry(dir
				+ System.getProperty("file.separator") + fileName);
		zos.putNextEntry(zipEntry);
		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}
		zos.closeEntry();
		fis.close();
	}

	/**
	 * @param defFile
	 * @return Meta Content
	 */
	public static String getMetaContent(String defFile) {
		StringBuilder sb = new StringBuilder();
		sb.append("TOSCA-Meta-Version: 1.0\n"); //$NON-NLS-1$
		sb.append("CSAR-Version: 1.0\n"); //$NON-NLS-1$
		sb.append("Created-By: c-Eclipse\n\n"); //$NON-NLS-1$
		sb.append("Name: Definitions" + System.getProperty("file.separator") + defFile + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
		sb.append("Content-Type: application/vnd.oasis.tosca.definitions\n"); //$NON-NLS-1$
		return sb.toString();
	}

	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	private URLConnection getHttpsConnection(URL url) {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs,
					String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs,
					String authType) {
			}
		} };
		// Install the all-trusting trust manager
		SSLContext sc = null;
		try {
			sc = SSLContext.getInstance("SSL");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {

			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		URLConnection connection = null;
		try {
			connection = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	  // Call CELAR Manager to submit application description
	  private String describeApplication( String uri ) {
	    URL url = null;
	    HttpURLConnection connection = null;
	    String applicationId = null;
	    try {
	      url = new URL( uri + "/application/describe/" );
	      connection = ( HttpURLConnection )url.openConnection();
	      connection.setDoOutput( true );
	      connection.setDoInput( true );
	      connection.setRequestMethod( "POST" );
	      connection.setRequestProperty( "Content-type", "application/octet-stream" );
	      OutputStream reqStream = connection.getOutputStream();
	      FileInputStream fis = new FileInputStream( this.csar );
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      byte[] buf = new byte[ 1024 ];
	      try {
	        for( int readNum; ( readNum = fis.read( buf ) ) != -1; ) {
	          bos.write( buf, 0, readNum );
	        }
	      } catch( IOException ex ) {
	        ex.printStackTrace();
	      }
	      fis.close();
	      reqStream.write( bos.toByteArray() );
	      int responseCode = connection.getResponseCode();
	      System.out.println( "Response is: " + responseCode );
	      MessageConsole myConsole = findConsole( "MyConsole" );
	      MessageConsoleStream out = myConsole.newMessageStream();
	      out.println( "Describing application: HTTP Response is " + responseCode );
	      InputStream inputStream = connection.getInputStream();
	      // BufferedReader in = new BufferedReader(new
	      // InputStreamReader(inputStream));
	      // String inputLine;
	      // while ((inputLine = in.readLine()) != null) {
	      // System.out.println(inputLine);
	      // }
	      // in.close();
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = null;
	      try {
	        db = dbf.newDocumentBuilder();
	      } catch( ParserConfigurationException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      try {
	        Document doc = db.parse( inputStream );
	        // NodeList nList = doc.getElementsByTagName( "applicationInfo" );
	        NodeList nList = doc.getElementsByTagName( "modules" );
	        for( int i = 0; i < nList.getLength(); i++ ) {
	          Node nNode = nList.item( i );
	          if( nNode.getNodeType() == Node.ELEMENT_NODE ) {
	            Element eElement = ( Element )nNode;
	            // applicationId =
	            // eElement.getElementsByTagName("unique_Id").item(0).getTextContent();
	            applicationId = eElement.getElementsByTagName( "application_Id" )
	              .item( 0 )
	              .getTextContent();
	            break;
	          }
	        }
	      } catch( SAXException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      System.out.println( "Application Id is: " + applicationId );
	      connection.disconnect();
	    } catch( IOException ex ) {
	      ex.printStackTrace();
	    }
	    return applicationId;
	  }

	  // Call CELAR Manager to submit application description
	  private String describeApplicationHttps( String uri ) {
	    String applicationId = "";
	    URL url = null;
	    try {
	      url = new URL( uri + "/application/describe/" );
	    } catch( MalformedURLException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	    URLConnection connection = getHttpsConnection( url );
	    Writer writer = null;
	    try {
	      connection.setDoOutput( true );
	      connection.setDoInput( true );
	      connection.setRequestProperty( "Content-type", "application/octet-stream" );
	      FileInputStream fis = new FileInputStream( this.csar );
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      byte[] buf = new byte[ 1024 ];
	      try {
	        for( int readNum; ( readNum = fis.read( buf ) ) != -1; ) {
	          bos.write( buf, 0, readNum );
	        }
	      } catch( IOException ex ) {
	        ex.printStackTrace();
	      }
	      fis.close();
	      writer = new OutputStreamWriter( connection.getOutputStream() );
	      writer.write( bos.toString() );
	      writer.close();
	      // Get HTTP Response
	      InputStream inputStream = connection.getInputStream();
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = null;
	      try {
	        db = dbf.newDocumentBuilder();
	      } catch( ParserConfigurationException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      try {
	        Document doc = db.parse( inputStream );
	        NodeList nList = doc.getElementsByTagName( "application" );
	        for( int i = 0; i < nList.getLength(); i++ ) {
	          Node nNode = nList.item( i );
	          if( nNode.getNodeType() == Node.ELEMENT_NODE ) {
	            Element eElement = ( Element )nNode;
	            applicationId = eElement.getElementsByTagName( "id" )
	              .item( 0 )
	              .getTextContent();
	            break;
	          }
	        }
	        System.out.println( applicationId );
	      } catch( SAXException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	    } catch( IOException e ) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    return applicationId;
	  }

	  // Call CELAR Manager to deploy described application
	  private String deployApplication( String uri, String applicationId ) {
	    URL url = null;
	    HttpURLConnection connection = null;
	    String deploymentId = null;
	    try {
	      url = new URL( uri + "/application/" + applicationId + "/deploy/" );
	      connection = ( HttpURLConnection )url.openConnection();
	      connection.setDoOutput( true );
	      connection.setDoInput( true );
	      connection.setRequestMethod( "POST" );
	      connection.setRequestProperty( "Content-type", "application/octet-stream" );
	      OutputStream reqStream = connection.getOutputStream();
	      FileInputStream fis = new FileInputStream( this.csar );
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      byte[] buf = new byte[ 1024 ];
	      try {
	        for( int readNum; ( readNum = fis.read( buf ) ) != -1; ) {
	          bos.write( buf, 0, readNum );
	        }
	      } catch( IOException ex ) {
	        ex.printStackTrace();
	      }
	      fis.close();
	      reqStream.write( bos.toByteArray() );
	      int responseCode = connection.getResponseCode();
	      System.out.println( "Response is: " + responseCode );
	      MessageConsole myConsole = findConsole( "MyConsole" );
	      MessageConsoleStream out = myConsole.newMessageStream();
	      out.println( "Deploying application: HTTP Response is " + responseCode );
	      InputStream inputStream = connection.getInputStream();
	      // BufferedReader in = new BufferedReader(new
	      // InputStreamReader(inputStream));
	      // String inputLine;
	      // while ((inputLine = in.readLine()) != null) {
	      // System.out.println(inputLine);
	      // }
	      // in.close();
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = null;
	      try {
	        db = dbf.newDocumentBuilder();
	      } catch( ParserConfigurationException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      try {
	        Document doc = db.parse( inputStream );
	        NodeList nList = doc.getElementsByTagName( "modules" );
	        for( int i = 0; i < nList.getLength(); i++ ) {
	          Node nNode = nList.item( i );
	          if( nNode.getNodeType() == Node.ELEMENT_NODE ) {
	            Element eElement = ( Element )nNode;
	            deploymentId = eElement.getElementsByTagName( "id" )
	              .item( 0 )
	              .getTextContent();
	            break;
	          }
	        }
	      } catch( SAXException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      System.out.println( "Deployment Id is: " + deploymentId );
	      connection.disconnect();
	    } catch( IOException ex ) {
	      ex.printStackTrace();
	    }
	    return deploymentId;
	  }

	  // Call CELAR Manager to deploy described application
	  private String deployApplicationHttps( String uri, String applicationId ) {
	    String deploymentId = null;
	    URL url = null;
	    try {
	      url = new URL( uri + "/application/" + applicationId + "/deploy/" );
	    } catch( MalformedURLException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	    URLConnection connection = getHttpsConnection( url );
	    Writer writer = null;
	    try {
	      connection.setDoOutput( true );
	      connection.setDoInput( true );
	      connection.setRequestProperty( "Content-type", "application/octet-stream" );
	      FileInputStream fis = new FileInputStream( this.csar );
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      byte[] buf = new byte[ 1024 ];
	      try {
	        for( int readNum; ( readNum = fis.read( buf ) ) != -1; ) {
	          bos.write( buf, 0, readNum );
	        }
	      } catch( IOException ex ) {
	        ex.printStackTrace();
	      }
	      fis.close();
	      writer = new OutputStreamWriter( connection.getOutputStream() );
	      writer.write( bos.toString() );
	      // Get HTTP Response
	      InputStream inputStream = connection.getInputStream();
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      DocumentBuilder db = null;
	      try {
	        db = dbf.newDocumentBuilder();
	      } catch( ParserConfigurationException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      try {
	        Document doc = db.parse( inputStream );
	        NodeList nList = doc.getElementsByTagName( "deployment" );
	        for( int i = 0; i < nList.getLength(); i++ ) {
	          Node nNode = nList.item( i );
	          if( nNode.getNodeType() == Node.ELEMENT_NODE ) {
	            Element eElement = ( Element )nNode;
	            deploymentId = eElement.getElementsByTagName( "deploymentID" )
	              .item( 0 )
	              .getTextContent();
	            break;
	          }
	        }
	      } catch( SAXException e ) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	      }
	      System.out.println( "Deployment Id is: " + deploymentId );
	    } catch( IOException ex ) {
	      ex.printStackTrace();
	    }
	    return deploymentId;
	  }

	  // Get deployment state
	  private boolean getDeploymentState( String uri, String deploymentId ) {
	    URL url = null;
	    HttpURLConnection connection = null;
	    try {
	      url = new URL( uri + "/deployment/" + deploymentId );
	      connection = ( HttpURLConnection )url.openConnection();
	      connection.setDoOutput( false );
	      connection.setDoInput( true );
	      connection.setRequestMethod( "GET" );
	      int responseCode = connection.getResponseCode();
	      System.out.println( "Response is: " + responseCode );
	      MessageConsole myConsole = findConsole( "MyConsole" );
	      MessageConsoleStream out = myConsole.newMessageStream();
	      out.println( "Getting deployment status: HTTP Response is "
	                   + responseCode );
	      InputStream inputStream = connection.getInputStream();
	      // BufferedReader in = new BufferedReader(new
	      // InputStreamReader(inputStream));
	      // String inputLine;
	      // while ((inputLine = in.readLine()) != null) {
	      // System.out.println(inputLine);
	      // }
	      // in.close();
	      BufferedReader in = new BufferedReader( new InputStreamReader( inputStream ) );
	      String inputLine;
	      while( ( inputLine = in.readLine() ) != null ) {
	        out.println( inputLine );
	      }
	      in.close();
	      // DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      // DocumentBuilder db = null;
	      // try {
	      // db = dbf.newDocumentBuilder();
	      // } catch( ParserConfigurationException e ) {
	      // // TODO Auto-generated catch block
	      // e.printStackTrace();
	      // }
	      //
	      // try {
	      // Document doc = db.parse(inputStream);
	      // NodeList nList = doc.getElementsByTagName( "deployment" );
	      // for (int i=0; i< nList.getLength(); i++){
	      // Node nNode = nList.item(i);
	      //
	      // if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	      //
	      // Element eElement = (Element) nNode;
	      //
	      // deploymentId =
	      // eElement.getElementsByTagName("deploymentID").item(0).getTextContent();
	      //
	      // break;
	      // }
	      // }
	      // } catch( SAXException e ) {
	      // // TODO Auto-generated catch block
	      // e.printStackTrace();
	      // }
	      //
	      // System.out.println("Deployment Id is: "+deploymentId);
	      connection.disconnect();
	    } catch( IOException ex ) {
	      ex.printStackTrace();
	    }
	    return true;
	  }

	  // Get deployment state
	  private boolean getDeploymentStateHttps( String uri, String deploymentId ) {
	    URL url = null;
	    try {
	      url = new URL( uri + "/deployment/" + deploymentId );
	    } catch( MalformedURLException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	    URLConnection connection = getHttpsConnection( url );
	    try {
	      connection.setDoOutput( false );
	      connection.setDoInput( true );
	      MessageConsole myConsole = findConsole( "MyConsole" );
	      MessageConsoleStream out = myConsole.newMessageStream();
	      out.println( "Getting deployment status: HTTP Response is " );
	      InputStream inputStream = connection.getInputStream();
	      // BufferedReader in = new BufferedReader(new
	      // InputStreamReader(inputStream));
	      // String inputLine;
	      // while ((inputLine = in.readLine()) != null) {
	      // System.out.println(inputLine);
	      // }
	      // in.close();
	      BufferedReader in = new BufferedReader( new InputStreamReader( inputStream ) );
	      String inputLine;
	      while( ( inputLine = in.readLine() ) != null ) {
	        out.println( inputLine );
	      }
	      in.close();
	      // DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      // DocumentBuilder db = null;
	      // try {
	      // db = dbf.newDocumentBuilder();
	      // } catch( ParserConfigurationException e ) {
	      // // TODO Auto-generated catch block
	      // e.printStackTrace();
	      // }
	      //
	      // try {
	      // Document doc = db.parse(inputStream);
	      // NodeList nList = doc.getElementsByTagName( "deployment" );
	      // for (int i=0; i< nList.getLength(); i++){
	      // Node nNode = nList.item(i);
	      //
	      // if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	      //
	      // Element eElement = (Element) nNode;
	      //
	      // deploymentId =
	      // eElement.getElementsByTagName("deploymentID").item(0).getTextContent();
	      //
	      // break;
	      // }
	      // }
	      // } catch( SAXException e ) {
	      // // TODO Auto-generated catch block
	      // e.printStackTrace();
	      // }
	      //
	      // System.out.println("Deployment Id is: "+deploymentId);
	    } catch( IOException ex ) {
	      ex.printStackTrace();
	    }
	    return true;
	  }

	  // Terminate deployment
	  private boolean terminateDeployment( String uri, String deploymentId ) {
	    URL url = null;
	    HttpURLConnection connection = null;
	    try {
	      url = new URL( uri + "/deployment/" + deploymentId + "/terminate" );
	      connection = ( HttpURLConnection )url.openConnection();
	      connection.setDoOutput( false );
	      connection.setDoInput( true );
	      connection.setRequestMethod( "GET" );
	      int responseCode = connection.getResponseCode();
	      System.out.println( "Response is: " + responseCode );
	      InputStream inputStream = connection.getInputStream();
	      BufferedReader in = new BufferedReader( new InputStreamReader( inputStream ) );
	      String inputLine;
	      while( ( inputLine = in.readLine() ) != null ) {
	        System.out.println( inputLine );
	      }
	      in.close();
	      // DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      // DocumentBuilder db = null;
	      // try {
	      // db = dbf.newDocumentBuilder();
	      // } catch( ParserConfigurationException e ) {
	      // // TODO Auto-generated catch block
	      // e.printStackTrace();
	      // }
	      //
	      // try {
	      // Document doc = db.parse(inputStream);
	      // NodeList nList = doc.getElementsByTagName( "deployment" );
	      // for (int i=0; i< nList.getLength(); i++){
	      // Node nNode = nList.item(i);
	      //
	      // if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	      //
	      // Element eElement = (Element) nNode;
	      //
	      // deploymentId =
	      // eElement.getElementsByTagName("deploymentID").item(0).getTextContent();
	      //
	      // break;
	      // }
	      // }
	      // } catch( SAXException e ) {
	      // // TODO Auto-generated catch block
	      // e.printStackTrace();
	      // }
	      //
	      // System.out.println("Deployment Id is: "+deploymentId);
	      connection.disconnect();
	    } catch( IOException ex ) {
	      ex.printStackTrace();
	    }
	    return true;
	  }

	  // Terminate deployment
	  private boolean terminateDeploymentHttps( String uri, String deploymentId ) {
	    URL url = null;
	    try {
	      url = new URL( uri + "/deployment/" + deploymentId + "/terminate" );
	    } catch( MalformedURLException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
	    }
	    URLConnection connection = getHttpsConnection( url );
	    try {
	      connection.setDoOutput( false );
	      connection.setDoInput( true );
	      InputStream inputStream = connection.getInputStream();
	      BufferedReader in = new BufferedReader( new InputStreamReader( inputStream ) );
	      String inputLine;
	      while( ( inputLine = in.readLine() ) != null ) {
	        System.out.println( inputLine );
	      }
	      in.close();
	      // DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      // DocumentBuilder db = null;
	      // try {
	      // db = dbf.newDocumentBuilder();
	      // } catch( ParserConfigurationException e ) {
	      // // TODO Auto-generated catch block
	      // e.printStackTrace();
	      // }
	      //
	      // try {
	      // Document doc = db.parse(inputStream);
	      // NodeList nList = doc.getElementsByTagName( "deployment" );
	      // for (int i=0; i< nList.getLength(); i++){
	      // Node nNode = nList.item(i);
	      //
	      // if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	      //
	      // Element eElement = (Element) nNode;
	      //
	      // deploymentId =
	      // eElement.getElementsByTagName("deploymentID").item(0).getTextContent();
	      //
	      // break;
	      // }
	      // }
	      // } catch( SAXException e ) {
	      // // TODO Auto-generated catch block
	      // e.printStackTrace();
	      // }
	      //
	      // System.out.println("Deployment Id is: "+deploymentId);
	    } catch( IOException ex ) {
	      ex.printStackTrace();
	    }
	    return true;
	  }

	// Opens an internal browser displaying the Information System
	private void openISbrowser() {
		URL ISbrowser = null;
		try {
			ISbrowser = new URL(
					"http://snf-354013.vm.okeanos.grnet.gr:8080/webFrontend/application/version/deployment/?deplID=9876&tab=monitoring"); //$NON-NLS-1$
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		IWebBrowser browser;
		try {
			browser = PlatformUI.getWorkbench().getBrowserSupport()
					.createBrowser("id"); //$NON-NLS-1$
			browser.openURL(ISbrowser);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
