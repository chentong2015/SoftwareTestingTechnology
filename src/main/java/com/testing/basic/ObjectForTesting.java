package com.testing.basic;

public class ObjectForTesting {

    private String name;
    private String url;

    public ObjectForTesting(String name) {
        this.name = name;
        url = "http://realcode.com/testing";
    }

    // @VisibleForTesting
    // 该构造器只在测试的时候可见，在构造的时候，可以自动注入要测试的url(改变发送请求的target)
    public ObjectForTesting(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
