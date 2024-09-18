package com.mockito.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

// Mockito提供丰富ArgumentMatchers参数匹配条件，替代传递的(实际)参数
// - any() & anyList() 不会做任何参数判断，不会验证参数非Null
// - any(Type.class); 参数会做instanceof的类型判断
public class ArgumentMatchersTest {

    @Test
    public void testSayHelloToAnyString() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.sayHello(anyString())).thenReturn("ok");

        Assertions.assertEquals("ok", mockClass.sayHello("java"));
        Assertions.assertEquals("ok", mockClass.sayHello("test"));
    }

    @Test
    public void testSayHelloToSubString() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.sayHello(contains("ab"))).thenReturn("ok");

        Assertions.assertEquals("ok", mockClass.sayHello("java ab"));
        Assertions.assertEquals("ok", mockClass.sayHello("test ab"));
    }

    @Test
    public void testCalculateAnything() {
        MyMockitoClass mockClass = Mockito.mock(MyMockitoClass.class);
        Mockito.when(mockClass.calculate(anyInt())).thenReturn(10);

        Assertions.assertEquals(10, mockClass.calculate(2));
        Assertions.assertEquals(10, mockClass.calculate(0));
    }

    // TODO. 集合匹配时能够完成类型推断
    // ArgumentMatchers.anyList()
    // ArgumentMatchers.<List<String>>any()
    // ArgumentMatchers.<String,Object>anyMap()
    @Test
    public void testAnyListParameters() {
        MyMockitoClass mockMyList = Mockito.mock(MyMockitoClass.class);
        when(mockMyList.testListParameters(ArgumentMatchers.anyList())).thenReturn("AnyList");

        List<List<String>> listList = new ArrayList<>();
        List<List<String>> listList2 = new ArrayList<>();
        listList2.add(List.of("item 1", "item 2"));
        Assertions.assertEquals("AnyList", mockMyList.testListParameters(listList));
        Assertions.assertEquals("AnyList", mockMyList.testListParameters(listList2));
    }
}
