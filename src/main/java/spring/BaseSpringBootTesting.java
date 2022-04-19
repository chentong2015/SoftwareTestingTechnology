package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// TODO：Spring Boot测试
// https://spring.io/guides/gs/testing-web/
// https://www.baeldung.com/spring-boot-testing
// https://www.javadevjournal.com/spring-boot/shutdown-spring-boot-application/ 测试后关闭

// @SpringBootApplication(exclude=SecurityAutoConfiguration.class) 在测试时自定义移除指定的配置
@SpringBootApplication
public class BaseSpringBootTesting {

    // The testing frameworks you need to integrate into your code
    // TODO: spring-boot-starter-test 集成了下面的四种测试
    //   JUnit       (for all unit testing)
    //     从Spring Boot 2.4开始，没有集成JUnit5
    //     如果要测试JUnit4的功能，需要补充Dependency
    //   Hamcrest    (for matching and assertions)
    //   Mockito     (mock objects and verify)
    //     已经内置了相关的测试依赖，无需再次添加
    //   Sprint Test (Testing tool and integration testing support)

    // Implementing Integration Testing
    //   The reason behind writing integration tests
    //   How Spring Boot overcomes the problems of integration testing
    //   Web Integration Testing
    //   Needed for testing the REST API calls

    // Spring Unit Test -> Integration Test
    // 1. add @RunWith(SpringJUnit4ClassRunner.class)
    //    指定要运行的ClassRunner, 已经集成到Spring Test Tool中
    // 2. add @SpringApplicationConfiguration(Application.class)
    //    配置和提供启动App的类型，embed that inside of the context of a unit test
    // 3. @WebIntegrationTest -> Web Integration Test 这个注解针对于Web集成测试

    // TODO: 通过获取Spring boot容器ApplicationContext，测试main()方法启动后的正确性
    public static void main(String[] args) {
        System.out.println("Start application");
        SpringApplication.run(BaseSpringBootTesting.class, args);
    }
}
