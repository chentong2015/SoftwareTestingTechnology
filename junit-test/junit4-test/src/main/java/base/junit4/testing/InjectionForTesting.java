package base.junit4.testing;

import java.util.logging.Logger;

// TODO. 提供特定的构造器注入参数，提供测试扩展
public class InjectionForTesting {

    private final String name;
    private final String url;
    private final Logger logger;

    public InjectionForTesting(String name) {
        this(name, "https://demo.com/testing");
    }

    // @VisibleForTesting
    // 在测试的时候可见，自动注入要测试的url(改变发送请求的target)
    public InjectionForTesting(String name, String url) {
        this(name, url, Logger.getLogger("test"));
    }

    // Logger可以在测试时提供额外的注入
    public InjectionForTesting(String name, String url, Logger logger) {
        this.name = name;
        this.url = url;
        this.logger = logger;
    }
}
