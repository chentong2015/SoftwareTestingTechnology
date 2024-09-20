package com.mockito.testing.injection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

// Class MockitoAnnotations
// https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/MockitoAnnotations.html
public class InjectionMockTest {

    @Mock
    EmailService emailService;

    // TODO. 由于ApplicationService依赖于EmailService
    //  @InjectMocks会自动完成对EmailService Mock对象的注入并生成对象
    @InjectMocks
    ApplicationService applicationService;

    private AutoCloseable autoCloseable;

    // TODO. 在自定义Mock方法前必须先实例化注入的Mock对象 !!
    // Initializes objects annotated with Mockito annotations: @Mock, @Spy, @Captor, @InjectMocks
    @BeforeEach
    public void setUps() {
        // MockitoAnnotations.initMocks(this); 已经废弃
        this.autoCloseable = MockitoAnnotations.openMocks(this);
    }

    // Inject Mock之后应该调用close()方法
    @AfterEach
    public void cleanup() throws Exception {
        this.autoCloseable.close();
    }

    @Test
    public void testInjectMock() {
        Mockito.when(applicationService.sendEmail("test")).thenReturn(true);
        Assertions.assertTrue(applicationService.sendEmail("test"));
    }
}
