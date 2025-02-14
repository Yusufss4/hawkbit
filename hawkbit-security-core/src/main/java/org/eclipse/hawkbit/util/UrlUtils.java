/**
 * Copyright (c) 2023 Bosch.IO GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.util;

import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;

public class UrlUtils {

  private UrlUtils() {
    // Util classes should not have public constructors
  }

  public static String decodeUriValue(String value) {
    return UriUtils.decode(value, StandardCharsets.UTF_8);
  }

}
