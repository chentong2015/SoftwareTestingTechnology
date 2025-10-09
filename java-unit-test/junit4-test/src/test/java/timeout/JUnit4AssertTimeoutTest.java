package timeout;

import org.junit.Test;

public class JUnit4AssertTimeoutTest {

    // Fails if the unit test method takes more than 3 seconds
    @Test(timeout = 3000)
    public void testTimeout() throws InterruptedException {
        System.out.println("Test time out");
        Thread.sleep(2000);
    }
}
