package com.mockito.testing.statiz;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;

// TODO. The single registration constraint. 单一注册机制
// “static mocking is already registered in the current thread”
// When attempting to register multiple static mocks within the same thread context
// To resolve this issue, we must deregister the existing static mock before creating a new one.
public class SingleStaticMockRegistrationTest {

    private MockedStatic<MyStaticUtils> mockStatic;

    // Registering a static mock for UserService before each test
    @BeforeEach
    public void setUp() {
        mockStatic = mockStatic(MyStaticUtils.class);
    }

    // MockedStatic.close() method must be called upon completing the test
    //  or the mock will remain active on the current thread.
    @AfterEach
    public void tearDown() {
        mockStatic.close();
    }

    @Test
    public void givenStaticMockRegistration_whenMocked_thenReturnsMockSuccessfully() {
        // Ensure that the static mock for UserService is registered
        assertTrue(Mockito.mockingDetails(MyStaticUtils.class).isMock());
    }

    @Test
    public void givenAnotherStaticMockRegistration_whenMocked_thenReturnsMockSuccessfully() {
        // Ensure that the static mock for UserService is registered
        assertTrue(Mockito.mockingDetails(MyStaticUtils.class).isMock());
    }

    // TODO. 在测试方法中再次注入Mock Static将会抛出异常
    @Test
    public void testMultiStaticMockRegistrations() {
        try (MockedStatic<MyStaticUtils> utilObject = Mockito.mockStatic(MyStaticUtils.class)) {
            utilObject.when(MyStaticUtils::name).thenReturn("chen");
            assertEquals("chen", MyStaticUtils.name());
        }
    }
}
