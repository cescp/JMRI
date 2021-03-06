package jmri.web.server;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Tests for the jmri.web.server.WebServerPreferencesPanel class
 *
 * @author Paul Bender Copyright (C) 2012, 2016
 */
public class WebServerPreferencesPanelTest {

    @Test
    public void testCtor() {
        WebServerPreferencesPanel a = new WebServerPreferencesPanel();
        Assert.assertNotNull(a);
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        JUnitUtil.resetProfileManager();
        jmri.InstanceManager.setDefault(WebServerPreferences.class, new WebServerPreferences());
        JUnitUtil.initStartupActionsManager();
    }

    @AfterEach
    public void tearDown() {
        JUnitUtil.tearDown();
    }
}
