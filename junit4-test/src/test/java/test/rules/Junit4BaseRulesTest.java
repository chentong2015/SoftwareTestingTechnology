package test.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import test.rules.demo.ConsoleOutTestRule;
import test.rules.demo.PerformanceLoggerTestRule;

import static org.junit.Assert.assertTrue;

// Junit4提供的预定义规则Rules(类库一部分)，测试的加强和扩展
// 1. A number of useful, predefined rules as part of the library.
// 2. Enhance tests by running some code around a test case execution
// 3. 类似于@Before and @After annotations注解的作用
// 4. 在多个Test classes中都需要连接和关闭资源，则可以通过Rule将改操作隔离出来，重用
public class Junit4BaseRulesTest {

    // TODO. @Rule测试规则将会作用在每一个单元测试上
    @Rule
    public PerformanceLoggerTestRule performanceLogger = new PerformanceLoggerTestRule();

    // 设置TestRule的链条，在测试过程中指定"从内向外"的输出顺序，先处理内部的逻辑
    @Rule
    public RuleChain chain = RuleChain.outerRule(new ConsoleOutTestRule("First rule"))
            .around(new ConsoleOutTestRule("Second rule"))
            .around(new ConsoleOutTestRule("Third rule"));

    @Test
    public void testRule() throws InterruptedException {
        System.out.println("my unit test");
        Thread.sleep(2000);
        assertTrue(true);
    }

    @Test
    public void testOthers() {
        System.out.println("test others");
        assertTrue(true);
    }
}