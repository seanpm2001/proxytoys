/*
 * (c) 2010 ThoughtWorks Ltd
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 19-03-2010.
 */
package com.thoughtworks.proxy.toys.privilege;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

public class AccessControllerExecutor implements ActionExecutor
{
    private final AccessControlContext context;

    public AccessControllerExecutor() {
        this(null);
    }

    public AccessControllerExecutor(AccessControlContext context) {
        this.context = context;
    }

    public Object execute(PrivilegedExceptionAction<Object> action) throws PrivilegedActionException
    {
        return AccessController.doPrivileged(action, context);
    }
}
