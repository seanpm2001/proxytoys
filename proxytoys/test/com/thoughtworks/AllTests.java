/*
 * Created on 23-Mar-2004
 * 
 * (c) 2003-2004 ThoughtWorks Ltd
 *
 * See license.txt for license details
 */
package com.thoughtworks;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.thoughtworks.nothing.NullTest;
import com.thoughtworks.proxytoys.DelegatingProxyTest;
import com.thoughtworks.proxytoys.EchoProxyTest;

/**
 * @author <a href="mailto:dan.north@thoughtworks.com">Dan North</a>
 */
public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.thoughtworks");
		//$JUnit-BEGIN$
        suite.addTestSuite(NullTest.class);
		suite.addTestSuite(EchoProxyTest.class);
		suite.addTestSuite(DelegatingProxyTest.class);
		//$JUnit-END$
		return suite;
	}
}