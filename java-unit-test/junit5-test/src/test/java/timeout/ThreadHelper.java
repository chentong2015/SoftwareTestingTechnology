package timeout;

// TODO. 在单元测试中尽量避免使用Thread.sleep(), 存在不精确性
// sleep(1000) 不保证精确睡眠1000ms
// 在高性能机器上，实际睡眠时间可能远少于1000ms
// 在慢速机器上，可能超过1000ms
public class ThreadHelper {

    public void demoSleep() throws InterruptedException {
        // 本地机器可能实际执行: 只睡眠了50ms
        Thread.sleep(1000);

        // CI环境可能: 睡眠了1100ms(超过2秒限制)
        Thread.sleep(1000);
    }

    public static void doSomething() throws InterruptedException {
        System.out.println("Start Test");
        Thread.sleep(2000);
        System.out.println("Finish Test");
    }
}
