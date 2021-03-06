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

package org.eclipse.camf.core.auth;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.camf.core.ExtensionManager;
import org.eclipse.camf.core.Extensions;
import org.eclipse.camf.core.ICoreProblems;
import org.eclipse.camf.core.internal.Activator;
import org.eclipse.camf.core.reporting.ProblemException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

/**
 * Abstract implementation of the {@link eu.geclipse.core.auth.IAuthTokenProvider}
 * interface that adds some static methods to deal with the extensions of that
 * interface. The most important methods are therefore the static access methods
 * for retrieving authentication tokens.
 * 
 * @author stuempert-m
 */
public abstract class AbstractAuthTokenProvider implements IAuthTokenProvider {

  /**
   * Checks if the specified {@link Throwable} was issued by a token request
   * cancelation.
   * 
   * @param t The {@link Throwable} to be checked.
   * @return <code>True</code> if the specified {@link Throwable} is a
   * {@link ProblemException} and the exception's id is equal to
   * {@link ICoreProblems#AUTH_TOKEN_REQUEST_CANCELED}.
   */
  public static boolean isTokenRequestCanceledException( final Throwable t ) {
    
    boolean result = false;
    
    if ( t != null ) {
    
      if ( t instanceof ProblemException ) {
        String id = ( ( ProblemException ) t ).getProblem().getID();
        result = ICoreProblems.AUTH_TOKEN_REQUEST_CANCELED.equals( id );
      }
      
      if ( ! result && ( t.getCause() != null ) ) {
        result = isTokenRequestCanceledException( t.getCause() );
      }
      
    }
    
    return result;
    
  }
  
  /**
   * Static access method that calls the corresponding method of the
   * token provider with the highest priority of all currently
   * registered providers.
   * 
   * @return An authentication token if at least one provider is 
   * registered and a token could be found.
   * @throws ProblemException If a problem occured during the token request.
   * This exception with the {@link ICoreProblems#AUTH_TOKEN_REQUEST_CANCELED}
   * id is especially thrown if the token request was canceled by the user.
   * @see eu.geclipse.core.auth.IAuthTokenProvider#requestToken()
   */
  public static synchronized IAuthenticationToken staticRequestToken() throws ProblemException {
    IAuthTokenProvider provider = getHighestPriorityProvider();
    return provider == null ? null : provider.requestToken();
  }
  
  /*public static synchronized IAuthenticationToken staticRequestToken( final IAuthenticationTokenDescription description ) {
    AuthTokenRequest request = new AuthTokenRequest( description, null, null );
    return staticRequestToken( request );
  }*/
  
  /**
   * Static access method that calls the corresponding method of the
   * token provider with the highest priority of all currently
   * registered providers.
   * 
   * @param request Request parameters for the token.
   * @return An authentication token if at least one provider is 
   * registered and a token could be found.
   * @throws ProblemException If a problem occured during the token request.
   * This exception with the {@link ICoreProblems#AUTH_TOKEN_REQUEST_CANCELED}
   * id is especially thrown if the token request was canceled by the user.
   * @see eu.geclipse.core.auth.IAuthTokenProvider#requestToken(AuthTokenRequest)
   */
  public static synchronized IAuthenticationToken staticRequestToken( final AuthTokenRequest request ) throws ProblemException {
    IAuthTokenProvider provider = getHighestPriorityProvider();
    return provider == null ? null : provider.requestToken( request );
  }
  
  /**
   * Get the token provider with the highest priority.
   * 
   * @return The token provider that has the highest priority of all
   * currently registered token providers. 
   */
  static private IAuthTokenProvider getHighestPriorityProvider() {
    
    ExtensionManager extensionBrowser = new ExtensionManager();
    List< IConfigurationElement > providers
      = extensionBrowser.getConfigurationElements( Extensions.AUTH_TOKEN_PROVIDER_POINT,
                                                   Extensions.AUTH_TOKEN_PROVIDER_ELEMENT );
    
    Hashtable< Integer, IConfigurationElement > providerMap
      = new Hashtable< Integer, IConfigurationElement >();
    
    for ( IConfigurationElement element : providers ) {
      String prioString = element.getAttribute( Extensions.AUTH_TOKEN_PROVIDER_PRIORITY_ATTRIBUTE );
      try {
        Integer prio = Integer.valueOf( prioString );
        providerMap.put( prio, element );
      } catch ( NumberFormatException nfExc ) {
        Activator.logException( nfExc );
      }
    }
    
    IAuthTokenProvider provider = null;
    Integer[] keys = providerMap.keySet().toArray( new Integer[ providerMap.size() ] );
    Arrays.sort( keys );
    
    for ( int i = keys.length - 1 ; ( i >= 0 ) && ( provider == null ) ; i-- ) {
      IConfigurationElement element = providerMap.get( keys[ i ] );
      try {
        provider = ( IAuthTokenProvider ) element.createExecutableExtension( Extensions.AUTH_TOKEN_PROVIDER_EXECUTABLE );
      } catch( CoreException cExc ) {
        Activator.logException( cExc );
      }
    }
    
    return provider;
    
  }
  
}
