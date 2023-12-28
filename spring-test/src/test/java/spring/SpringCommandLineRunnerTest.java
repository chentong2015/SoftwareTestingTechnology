package spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;

public class SpringCommandLineRunnerTest {

    @Test
    public void testCommandLine() throws Exception {
        BaseSpringBootTesting springBootApp = new BaseSpringBootTesting();
        CommandLineRunner commandLineRunner = springBootApp.commandLineRunner();
        String[] args = {"item1", "item2"};
        commandLineRunner.run(args);
        // 在调用方法之后，测试执行的逻辑
    }
}
