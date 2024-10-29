package test.rules;

import base.junit4.testing.MyServiceException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Junit4RulesApiTest {

    // 1. 测试测试获取方法的名称
    // TODO. @Rule注解的类型必须是实现了org.junit.rules.TestRule的类型
    @Rule
    public TestName name = new TestName();

    @Test
    public void testMethodName() {
        assertEquals("test Method Name", name.getMethodName());
    }

    // 2. 使用临时文件夹，不用考虑文件夹的创建和删除(在测试结束的时候自动删除)
    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void givenTempFolderRule_whenNewFile_thenFileIsCreated() throws IOException {
        File folder = tmpFolder.newFolder("/test");
        File testFile = tmpFolder.newFile("test/test-file.txt");
        assertTrue(testFile.exists());
        assertTrue("The file should have been created: ", testFile.isFile());
        assertEquals("Temp folder and test file should match: ", folder, testFile.getParentFile());
    }

    // 3. 测试对于控制台输出的测试
    // @Rule
    // public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    // @Test
    // public void givenSystemOutRule_whenInvokePrintln_thenLogSuccess() {
    //     System.out.println("Hello");
    //     Assert.assertEquals("Hello", systemOutRule.getLog().trim());
    // }

    // 4. 测试异常输出的Rule -> 推荐使用assertThrows()
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void throw_exception_with_expected() throws MyServiceException {
        exception.expect(MyServiceException.class);
        exception.expectCause(isA(NullPointerException.class));
        exception.expectCause(instanceOf(NullPointerException.class));
        exception.expectMessage("This is illegal");

        // mock the method called to throw exception
        throw new MyServiceException("This is illegal");
    }

    // 5. 定义一个全局的Timeout, 单元测试的时间不超过设置的时间
    @Rule
    public Timeout globalTimeout = new Timeout(10);

    @Test
    public void givenLongRunningTest_whenTimout_thenTestFails() throws InterruptedException {
        TimeUnit.SECONDS.sleep(20);
    }

    // 6. Collect all the errors and report them all at once when the test terminates
    @Rule
    public final ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void givenMultipleErrors_whenTestRuns_thenCollectorReportsErrors() {
        errorCollector.addError(new RuntimeException("Something went wrong"));
        errorCollector.addError(new RuntimeException("Something else went wrong"));
        errorCollector.addError(new RuntimeException("Other thing that went wrong"));
        // errorCollector.addError(new Throwable("First thing went wrong!"));
        // errorCollector.addError(new Throwable("Another thing went wrong!"));
        // errorCollector.checkThat("Hello World", not(containsString("ERROR!")));
    }
}
