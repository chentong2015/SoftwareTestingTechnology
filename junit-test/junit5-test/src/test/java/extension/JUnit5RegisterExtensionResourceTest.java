package extension;

import extension.rules.ExternalResourceExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

// TODO. 该注解注入的Extension会调用默认的构造器: 如果没有无参构造器，则不会执行单元测试
@ExtendWith(ExternalResourceExtension.class)
public class JUnit5RegisterExtensionResourceTest {

    // 该注解注入的Extension Class可以调用含参数的构造器
    // @RegisterExtension
    // ExternalResourceExtension extension = new ExternalResourceExtension("my config");

    @Test
    void testExtensionResource() {
        System.out.println("test extension resource");
        Assertions.assertTrue(true);
    }
}
