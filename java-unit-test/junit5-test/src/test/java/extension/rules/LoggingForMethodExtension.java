package extension.rules;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggingForMethodExtension implements BeforeEachCallback {

    private final String message;

    public LoggingForMethodExtension(String message) {
        this.message = message;
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Type {} In beforeEach : {}" + extensionContext.getDisplayName());
    }

    public String getMessage() {
        return "With message: " + message;
    }
}
