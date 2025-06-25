package com.mockito.testing.statiz;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// 测试Mock静态方法时，可能会抛出JVM提示，可以设置JvmArg参数'-Xshare:off'
// OpenJDK 64-Bit Server VM warning:
// Sharing is only supported for boot loader classes because bootstrap classpath has been appended
public class MyStaticUtilsTest {

    @Test
    public void testMockStaticMethodWithNoArgs() {
        assertEquals("test", MyStaticUtils.name());

        // TODO. mock static Scope 在作用域内所有对于静态方法的调用都一致
        try (MockedStatic<MyStaticUtils> utilObject = Mockito.mockStatic(MyStaticUtils.class)) {
            utilObject.when(MyStaticUtils::name).thenReturn("chen");
            assertEquals("chen", MyStaticUtils.name());
        }

        // 在Scope之外将恢复成原来逻辑
        assertEquals("test", MyStaticUtils.name());
    }

     @Test
    public void testMockStaticMethodWithArgs() {
         assertThat(MyStaticUtils.range(2, 6), Matchers.containsInAnyOrder(2, 3, 4, 5));

         try (MockedStatic<MyStaticUtils> utilities = Mockito.mockStatic(MyStaticUtils.class)) {
             utilities.when(() -> MyStaticUtils.range(2, 6)).thenReturn(Arrays.asList(10, 11, 12));
             assertThat(MyStaticUtils.range(2, 6), Matchers.containsInAnyOrder(10, 11, 12));
         }

         assertThat(MyStaticUtils.range(2, 6), Matchers.containsInAnyOrder(2, 3, 4, 5));
     }
}
