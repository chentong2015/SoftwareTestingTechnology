package com.testing.basic;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// TODO: hamcrest提供很多匹配和测试的选项
// 使得测试的逻辑更加的清晰，方便debug
// http://hamcrest.org/JavaHamcrest/tutorial
public class HamcrestExampleTest {

    @Test
    public void test_hamcrest() {
        assertThat(Math.sqrt(9), is(getNumber(1)));
    }

    private int getNumber(int value) {
        int result = 3 * value;
        return result;
    }
}
