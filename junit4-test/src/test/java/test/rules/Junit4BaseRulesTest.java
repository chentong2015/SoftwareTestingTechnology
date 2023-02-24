package test.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import test.rules.demo.ConsoleOutTestRule;
import test.rules.demo.PerformanceLoggerTestRule;

import static org.junit.Assert.assertTrue;

public class Junit4RulesTestChains {

    // 设置TestRule的链条，在测试过程中指定"从内向外"的输出顺序，先处理内部的逻辑
    @Rule
    public RuleChain chain = RuleChain.outerRule(new ConsoleOutTestRule("First rule"))
            .around(new ConsoleOutTestRule("Second rule"))
            .around(new ConsoleOutTestRule("Third rule"));

    // 补充自定义TestRule
    @Rule
    public PerformanceLoggerTestRule performanceLogger = new PerformanceLoggerTestRule();

    @Test
    public void testConsoleRule() throws InterruptedException {
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