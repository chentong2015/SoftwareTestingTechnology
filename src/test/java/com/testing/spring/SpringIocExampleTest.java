package com.testing.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseSpringBootTesting.class)
public class SpringIocExampleTest {

    // DataSource在APP启动的时候自动注入IoC容器中
    // 测试的时候直接Autowired，从IoC中获取bean对象
    // 然后测试对象的属性
    @Autowired
    DataSource dataSource;

    @Test
    void dataSource() {
        String url = "jdbc:mysql://localhost:3306/test";
        DriverManagerDataSource driverManagerDataSource = (DriverManagerDataSource) dataSource;
        Assertions.assertEquals(url, driverManagerDataSource.getUrl());
    }
}
