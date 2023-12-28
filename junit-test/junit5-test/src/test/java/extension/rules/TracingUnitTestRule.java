package extension.rules;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

// 通过继承指定的接口来实现Junit4 Rule的功能
public class TracingUnitTestRule implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("before the unit test been called");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("after the unit test been called");
    }
}
