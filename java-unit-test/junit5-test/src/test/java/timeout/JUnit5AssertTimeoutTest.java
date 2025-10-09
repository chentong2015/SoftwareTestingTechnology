package timeout;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class JUnit5AssertTimeoutTest {

    // TODO. assertTimeout() 在主线程来执行耗时操作
    // 超时后继续等待直到代码完成后报告失败，可能显然无限阻塞
    @Test
    public void testAssertTimeout() {
        Assertions.assertTimeout(Duration.ofSeconds(5), () -> {
            System.out.println(Thread.currentThread().getName()); // main thread
            ThreadHelper.doSomething();
        });
    }

    // TODO. assertTimeoutPreemptively() 在新线程来执行耗时操作
    // 主动中断: 超时后会立即中断测试，而不是等待代码自然结束
    // 防止无限阻塞: 即使被测代码卡死或进入无限循环，测试也能按Timeout时间结束
    @Test
    public void testAssertTimeoutPreemptively() {
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(5), () -> {
            System.out.println(Thread.currentThread().getName()); // junit-timeout-thread-1
            ThreadHelper.doSomething();
        });
    }

    // TODO. assertTimeoutPreemptively() 不适合中断后还需要清理的场景
    @Test
    public void testAssertTimeoutPreemptivelyCases() {
        // 测试性能要求严格的方法, 必须快速响应的操作
        // 防止外部依赖导致测试卡住, 网络调用或外部服务
        Assertions.assertTimeoutPreemptively(Duration.ofMillis(5000), ThreadHelper::doSomething);
        Assertions.assertTimeoutPreemptively(Duration.ofSeconds(10), ThreadHelper::doSomething);
    }


}
