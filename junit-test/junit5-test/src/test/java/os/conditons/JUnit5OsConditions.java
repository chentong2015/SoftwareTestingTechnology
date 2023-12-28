package os.conditons;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

import static org.junit.jupiter.api.condition.OS.*;

// 根据不同的OS平台部署测试
public class JUnit5OsConditions {

    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        System.out.println("only on mac os");
    }

    // 使用自定义的注解来实现：只在mac os上运行测试
    @TestOnMac
    void testOnMac() {
        System.out.println("test on mac");
    }

    @Test
    @EnabledOnOs({LINUX, MAC})
    void onLinuxOrMac() {
        System.out.println("linux or mac");
    }

    @Test
    @DisabledOnOs(WINDOWS)
    void notOnWindows() {
        System.out.println("only on windows");
    }
}
