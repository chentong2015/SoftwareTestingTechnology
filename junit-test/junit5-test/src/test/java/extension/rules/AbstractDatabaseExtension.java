package extension.rules;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AbstractDatabaseExtension implements BeforeEachCallback, AfterEachCallback {

    private String value;

    public AbstractDatabaseExtension(String value) {
        this.value = value;
        System.out.println("set value == ");
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("before each ExtensionContext ==== ");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("after each ExtensionContext ==== ");
    }
}
