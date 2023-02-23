package test.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import test.rules.demo.ConsoleOutTestRule;
import test.rules.demo.PerformanceLoggerTestRule;

import static org.junit.Assert.assertTrue;

public class Junit4TestRulesChains {

    // 设置TestRule的链条，在测试过程中指定"从内向外"的输出顺序，先处理内部的逻辑
    @Rule
    public RuleChain chain = RuleChain.outerRule(new ConsoleOutTestRule("First rule"))
            .around(new ConsoleOutTestRule("Second rule"))
            .around(new ConsoleOutTestRule("Third rule"));

    @Rule
    public ConsoleOutTestRule testRule = new ConsoleOutTestRule("test rule");

    // Third rule: Before test : example
    // Third rule: After test : example
    // Second rule: Before test : example
    // Second rule: After test : example
    // First rule: Before test : example
    // First rule: After test : example
    // Test Started .

    @Rule
    public PerformanceLoggerTestRule performanceLogger = new PerformanceLoggerTestRule();

    @Test
    public void testConsoleRule() throws InterruptedException {
        System.out.println("my unit test");
        Thread.sleep(2000);
        assertTrue(true);
    }
}