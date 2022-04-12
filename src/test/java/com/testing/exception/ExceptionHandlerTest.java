package com.testing.exception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionHandlerTest {

    // 使用指定的规则去测试异常抛出
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void throw_exception_with_expected() throws MyServiceException {
        exception.expect(MyServiceException.class);

        // mock the method called to throw exception
        throw new MyServiceException();
    }
}
