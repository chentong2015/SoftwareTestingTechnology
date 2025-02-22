package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.argThat;

// TODO. Custom Argument Matchers
// 使用argThat()自定义参数匹配器/匹配的规则，定义满足条件的参数
public class ArgumentMatchersCustomTest {

    @Test
    public void testMyArgumentMatcher() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.sayHello(argThat(new ArgumentMatcher<String>() {
            @Override
            public boolean matches(String s) {
                return s.startsWith("aa") && s.endsWith("bb");
            }
        }))).thenReturn("ok");
        Assertions.assertEquals("ok", mockClass.sayHello("aa1bb"));
    }
}
