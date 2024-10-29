package extension.exception;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class ExceptionExtensionHandler implements TestExecutionExceptionHandler {

    // 自定义单元测试上的异常处理器
    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {

    }
}
