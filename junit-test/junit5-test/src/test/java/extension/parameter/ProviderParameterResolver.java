package extension.parameter;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.engine.execution.BeforeEachMethodAdapter;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import parameterized.JUnit5ParameterizedMasterTest;

public class ProviderParameterResolver implements BeforeEachMethodAdapter, ParameterResolver {

    // TODO. 在执行@BeforeEach逻辑之前被触发
    @Override
    public void invokeBeforeEachMethod(ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) throws Throwable {
        
        ((JUnit5ParameterizedMasterTest) extensionContext.getTestInstance().get()).setUpSomething();
        System.out.println("invoke before each unit test");
    }

    // TODO. 解析单元测试方法参数是否符合条件，在执行@BeforeEach逻辑之后被触发
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        System.out.println(parameterContext.getParameter().getType() == String.class);
        System.out.println("supportsParameter ====");
        return false;
    }

    // 将符合条件的参数解析成另外一个对象
    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        System.out.println("resolveParameter ====");
        return "new value";
    }
}
