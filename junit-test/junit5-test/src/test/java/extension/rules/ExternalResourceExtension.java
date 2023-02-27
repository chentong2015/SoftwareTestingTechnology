package extension.rules;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

// TODO. 等效于Junit4 ExternalResource的设计架构
// 定义每一个单元测试执行的前后: 管理资源的连接和关闭
public abstract class ExternalResourceExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        // 重新连接资源 DataSource
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        // 关闭资源的连接
    }
}
