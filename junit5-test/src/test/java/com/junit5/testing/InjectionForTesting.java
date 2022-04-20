package com.junit5.testing;

// TODO. 测试技巧：提供特定的构造器，注入指定参数的值进行测试
public class InjectionForTesting {

    private final String name;
    private final String url;

    public InjectionForTesting(String name) {
        this.name = name;
        url = "https://realcode.com/testing";
    }

    // @VisibleForTesting
    // 该构造器只在测试的时候可见，在构造的时候，可以自动注入要测试的url(改变发送请求的target)
    public InjectionForTesting(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
