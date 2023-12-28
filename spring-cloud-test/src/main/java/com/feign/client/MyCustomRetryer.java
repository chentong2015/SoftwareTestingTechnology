package com.feign.client;

import feign.RetryableException;
import feign.Retryer;
import org.apache.http.HttpException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.conn.HttpHostConnectException;

public class MyCustomRetryer implements Retryer {

    private int count;

    @Override
    public void continueOrPropagate(RetryableException e) {
        final Throwable cause = e.getCause();
        if (cause instanceof HttpException) {
            HttpException httpCause = (HttpException) cause;
            count++;
            if (count > 6) {
                throw e;
            }
        } else if (cause instanceof HttpHostConnectException || cause instanceof NoHttpResponseException) {
            count++;
            if (count > 10) {
                throw e;
            }
        } else {
            // in case it was *not* an http error but a more low level error, rethrow
            throw e;
        }
    }

    @Override
    public Retryer clone() {
        return null;
    }
}
