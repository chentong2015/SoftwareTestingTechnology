package com.common.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

// 如果测试类和原始类在同一个路径下，则不需要引入package
class JunitCommonClassTest {

    @Test
    void testJUnit4() {
        JunitCommonClass commonClass = new JunitCommonClass();
        commonClass.testPrint();
        Assertions.assertTrue(true);
    }

    @Test
    void testResources() {
        String resourcePath = "sample.csv";
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(resourcePath);
        Assertions.assertNotNull(inputStream);
    }

    @Test
    void testPropertyResource() {
        ResourceBundle bundle = PropertyResourceBundle.getBundle("connection");
        System.out.println(bundle.getString("database.server"));
        System.out.println(bundle.getString("database.port"));
        Assertions.assertTrue(true);
    }
}
