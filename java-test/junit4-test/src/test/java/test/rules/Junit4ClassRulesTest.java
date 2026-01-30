package test.rules;

import org.junit.ClassRule;
import org.junit.Test;
import test.rules.demo.ConsoleOutTestRule;
import test.rules.demo.SystemPropertyIsDefined;

import static org.junit.Assert.assertTrue;

// TODO. @ClassRule
// 1. @ClassRule 'testRule' must be static 必须添加在静态属性上
// 2. 作用在Test Class上，运行整个测试类型只会执行一次
public class Junit4ClassRulesTest {

    @ClassRule
    public static ConsoleOutTestRule consoleRule = new ConsoleOutTestRule("test rule");

    @ClassRule
    public static SystemPropertyIsDefined systemProperty = new SystemPropertyIsDefined("name");

    @Test
    public void testClassRule() {
        System.out.println("test rule");
        assertTrue(true);
    }

    @Test
    public void testOthers() {
        System.out.println("new unit test");
        assertTrue(true);
    }
}
