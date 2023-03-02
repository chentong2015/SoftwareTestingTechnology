package com.common.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

// 如果测试类和原始类在同一个路径下，则不需要引入package
class JunitCommonClassTest {

    // 调用test-api中的类型机进行测试
    @Test
    void testJUnit4() {
        JunitCommonClass commonClass = new JunitCommonClass();
        commonClass.testPrint();
        Assertions.assertTrue(true);
    }

    // 使用test-api中classpath下的文件
    @Test
    void testClasspathResources() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("sample.csv");
        Assertions.assertNotNull(inputStream);
    }

    // 拿到connection.properties文件中的配置信息
    @Test
    void testPropertyResource() {
        ResourceBundle bundle = PropertyResourceBundle.getBundle("connection");
        System.out.println(bundle.getString("database.server"));
        System.out.println(bundle.getString("database.port"));
        Assertions.assertTrue(true);
    }

    // TODO: File & URL构建的是项目"根路径"下的相对路径, 区别于Classpath !!
    @Test
    void testFileInputStream() throws IOException {
        File file = new File("table");
        URL baseUrl = file.toURL();

        String tableList = "table-ordering.txt";
        InputStream tableListStream = (new URL(baseUrl, tableList)).openStream();
        Assertions.assertTrue(true);
    }
}
