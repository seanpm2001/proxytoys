/*
 * Created on 23-Mar-2004
 * 
 * (c) 2003-2004 ThoughtWorks Ltd
 *
 * See license.txt for license details
 */
package com.thoughtworks;

import com.thoughtworks.nothing.CGLIBNullTest;
import com.thoughtworks.nothing.StandardNullTest;
import com.thoughtworks.proxytoys.DelegatingProxyTest;
import com.thoughtworks.proxytoys.EchoProxyTest;
import com.thoughtworks.proxytoys.StandardHidingTestCase;
import com.thoughtworks.proxytoys.CGLIBHidingTestCase;
import com.thoughtworks.proxytoys.StandardMulticastTestCase;
import com.thoughtworks.proxytoys.CGLIBMulticastTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author <a href="mailto:dan.north@thoughtworks.com">Dan North</a>
 */
public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.thoughtworks.proxytoys");
		//$JUnit-BEGIN$
        suite.addTestSuite(StandardNullTest.class);
        suite.addTestSuite(CGLIBNullTest.class);
        suite.addTestSuite(StandardHidingTestCase.class);
        suite.addTestSuite(CGLIBHidingTestCase.class);
        suite.addTestSuite(StandardMulticastTestCase.class);
        suite.addTestSuite(CGLIBMulticastTestCase.class);
		suite.addTestSuite(EchoProxyTest.class);
		suite.addTestSuite(DelegatingProxyTest.class);
		//$JUnit-END$
		return suite;
	}
}
