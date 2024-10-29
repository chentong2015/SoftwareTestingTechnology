package extension.rules;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggingForClassExtension implements BeforeAllCallback, BeforeEachCallback {

    private final String message;

    public LoggingForClassExtension(String message) {
        this.message = message;
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("Type {} In beforeAll : {}" + extensionContext.getDisplayName());
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Type {} In beforeEach : {}" + extensionContext.getDisplayName());
    }

    public String getMessage() {
        return "With message: " + message;
    }
}
