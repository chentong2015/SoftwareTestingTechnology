package base.junit5.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

// JUnit5中提供Assumptions来做条件判断的假设
// 1. Assumptions.assumeThat();   "假设"不成立不会报错，同时不会执行后面的测试
// 2. MatcherAssert.assertThat(); "断言"不成立会报错Error
public class JUnit5Assumptions {

    @Test
    public void testAssumptions() {
        int value = 10;
        Boolean assumption = (value > 5) || (value < 11);
        Assumptions.assumeTrue(assumption, "the assumptions is not ok");

        System.out.println("run test");
        Assertions.assertTrue(true);
    }
}
