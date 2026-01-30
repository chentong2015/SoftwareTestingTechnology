package com.mockito.testing.injection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class InjectionMockTest {

    // TODO. 由于ApplicationService依赖于EmailService
    //  @InjectMocks会自动完成对EmailService Mock对象的注入并生成对象
    @InjectMocks
    ApplicationService applicationService;

    @Mock
    EmailService emailService;

    private AutoCloseable autoCloseable;

    // TODO. 在自定义Mock方法前必须先实例化注入的Mock对象
    // MockitoAnnotations.initMocks(this);  已经废弃
    // Initializes objects annotated with Mockito annotations: @Mock, @Spy, @Captor, @InjectMocks
    @BeforeEach
    public void setUps() {
        // TODO. openMocks() 不会初始化static实例字段，无法提供mock对象 !!
        this.autoCloseable = MockitoAnnotations.openMocks(this);
    }

    // TODO. 定义Inject生成的Bean对象特定方法的返回
    @Test
    public void testInjectMock() {
        Mockito.when(applicationService.sendEmail("test")).thenReturn(true);

        Assertions.assertTrue(applicationService.sendEmail("test"));
    }

    // Inject Mock之后应该调用close()方法
    @AfterEach
    public void cleanup() throws Exception {
        this.autoCloseable.close();
    }
}
