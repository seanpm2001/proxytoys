package com.thoughtworks.proxy;

import org.jmock.MockObjectTestCase;

/**
 * @author Aslak Helles&oslash;y
 * @version $Revision: 1.3 $
 */
public abstract class ProxyTestCase extends MockObjectTestCase {
    protected ProxyFactory proxyFactory;

    public ProxyTestCase() {
        proxyFactory = createProxyFactory();
    }

    protected abstract ProxyFactory createProxyFactory();
}