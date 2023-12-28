package com.common.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 如果测试类和原始类在同一个路径下，则不需要引入package
class JunitCommonClassTest {

    // 调用test-api中的类型机进行测试
    @Test
    void testJUnit4() {
        // JunitCommonClass commonClass = new JunitCommonClass();
        // commonClass.testPrint();
        Assertions.assertTrue(true);
    }

    // TODO. classpath中两个相同的文件在被读取时会报错 !!
    // 使用test-api中classpath下的文件: 优先选择当前项目classpath下的CSV文件
    @Test
    void testClasspathResources() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("sample.csv");
        Assertions.assertNotNull(inputStream);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            Stream<String> streams = bufferedReader.lines().skip(1);
            List<String> lines = streams.collect(Collectors.toList());
            System.out.println(lines.get(0));
            System.out.println(lines.get(1));
        }
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
