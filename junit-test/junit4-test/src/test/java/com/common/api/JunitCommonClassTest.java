package com.common.api;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class JunitCommonClassTest {

    @Test
    public void testJUnit4() {
        JunitCommonClass commonClass = new JunitCommonClass();
        commonClass.testPrint();
        Assert.assertTrue(true);
    }

    @Test
    public void testResources() {
        String resourcePath = "sample.csv";
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(resourcePath);
        Assert.assertNotNull(inputStream);
    }
}
