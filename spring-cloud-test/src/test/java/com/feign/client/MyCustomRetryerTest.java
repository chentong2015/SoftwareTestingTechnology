package com.feign.client;

import feign.FeignException;
import feign.Request;
import feign.RetryableException;
import org.junit.Assert;
import org.junit.Test;

public class MyCustomRetryerTest {

    // 直接调用.continueOrPropagate方法来进行重试的测试 !!
    @Test
    public void testCustomRetryer() {
        final RetryableException firstException = new RetryableException(404, "Test", Request.HttpMethod.GET, null, null);
        FeignException propagatedError = null;
        final MyCustomRetryer retryer = new MyCustomRetryer();
        try {
            retryer.continueOrPropagate(firstException);
        } catch (FeignException e) {
            propagatedError = e;
        }
        Assert.assertNull("No error should have been raised since the cause was a 404 status error.", propagatedError);

        final RetryableException secondException = new RetryableException(401, "Test", Request.HttpMethod.GET, null, null);
        try {
            retryer.continueOrPropagate(secondException);
        } catch (FeignException e) {
            propagatedError = e;
        }
        Assert.assertNull("No error should have been raised since the cause was a 401 status error.", propagatedError);
    }
}
