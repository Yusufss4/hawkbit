/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * Interface for Pre Authentication.
 */
public interface PreAuthenticationFilter {

    /**
     * Check if the filter is enabled.
     *
     * @param securityToken the secruity info
     * @return <code>true</code> is enabled <code>false</code> diabled
     */
    boolean isEnable(DmfTenantSecurityToken securityToken);

    /**
     * Extract the principal information from the current securityToken.
     *
     * @param securityToken the securityToken
     * @return the extracted tenant and controller id
     */
    HeaderAuthentication getPreAuthenticatedPrincipal(DmfTenantSecurityToken securityToken);

    /**
     * Extract the principal credentials from the current securityToken.
     *
     * @param securityToken the securityToken
     * @return the extracted tenant and controller id
     */
    Object getPreAuthenticatedCredentials(DmfTenantSecurityToken securityToken);

    /**
     * Allows to add additional authorities to the successful authenticated token.
     *
     * @return the authorities granted to the principal, or an empty collection if
     *         the token has not been authenticated. Never null.
     * @see Authentication#getAuthorities()
     */
    default Collection<GrantedAuthority> getSuccessfulAuthenticationAuthorities() {
        return Collections.emptyList();
    }

}
