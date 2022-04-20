package spring;


import javafx.application.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.config.SecurityAutoConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
// 在集成测试时，移除指定的配置Configuration的设置
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class SpringExcludeAutoConfigureTest {

    // 1. 使用PropertySource来移除
    // @RunWith(SpringRunner.class)
    // @SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.DEFINED_PORT)
    // @TestPropertySource(properties = "spring.autoconfigure.exclude=
    //   org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")

    // 2. 使用不同的profile配置来测试
    // @ActiveProfiles("test")
}
