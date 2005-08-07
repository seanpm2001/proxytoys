/*
 * Created on 04-Feb-2004
 * 
 * (c) 2003-2004 ThoughtWorks
 * 
 * See license.txt for licence details
 */
package com.thoughtworks.proxy.toys.delegate;

import com.thoughtworks.proxy.ProxyFactory;
import com.thoughtworks.proxy.factory.StandardProxyFactory;
import com.thoughtworks.proxy.kit.SimpleReference;


/**
 * Toy factory to create proxies delegating to another object.
 * <p>
 * Such a proxy is used to mask the methods of an object, that are not part of a public interface. Or it is used to make an
 * object compatible, e.g. when an object implements the methods of an interface, but does not implement the interface itself.
 * </p>
 * 
 * @author <a href="mailto:dan.north@thoughtworks.com">Dan North</a>
 * @since 0.1
 * @see com.thoughtworks.proxy.toys.delegate
 */
public class Delegating {
    /** Delegate must implement the method's interface */
    public static final boolean STATIC_TYPING = true;
    /** Delegate must have method with matching signature - not necessarily the same */
    public static final boolean DYNAMIC_TYPING = false;

    /**
     * Creating a delegating proxy for a special object.
     * 
     * @param type the type of the created proxy,
     * @param delegate the object the proxy delegates to.
     * @return a new proxy of the specified type.
     * @since 0.1
     */
    public static Object object(final Class type, final Object delegate) {
        return object(type, delegate, new StandardProxyFactory());
    }

    /**
     * Creating a delegating proxy for a special object.
     * 
     * @param type the type of the created proxy,
     * @param delegate the object the proxy delegates to.
     * @param staticTyping {@link #STATIC_TYPING} or {@link #DYNAMIC_TYPING}
     * @return a new proxy of the specified type.
     * @since 0.2
     */
    public static Object object(final Class type, final Object delegate, final boolean staticTyping) {
        final ProxyFactory factory = new StandardProxyFactory();
        return factory.createProxy(new Class[]{type}, new DelegatingInvoker(factory, new SimpleReference(delegate), staticTyping));
    }

    /**
     * Creating a delegating proxy for a special object using a special {@link ProxyFactory}.
     * 
     * @param type the type of the created proxy,
     * @param delegate the object the proxy delegates to.
     * @param factory the {@link ProxyFactory} to use creating the proxy.
     * @return a new proxy of the specified type.
     * @since 0.1
     */
    public static Object object(final Class type, final Object delegate, final ProxyFactory factory) {
        return factory
                .createProxy(new Class[]{type}, new DelegatingInvoker(factory, new SimpleReference(delegate), DYNAMIC_TYPING));
    }

    /** It's a factory, stupid */
    private Delegating() {
    }
}
