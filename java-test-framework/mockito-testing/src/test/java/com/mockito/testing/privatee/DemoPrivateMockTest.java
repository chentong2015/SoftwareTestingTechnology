package com.mockito.testing.privatee;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.Mockito;

import java.lang.reflect.Field;

// TODO. 通过反射修改Private属性，将对象的私有属性替换成Mock对象
public class DemoPrivateMockTest {

    private Person mockedPerson;

    @BeforeEach
    public void setUp(){
        mockedPerson = Mockito.mock(Person.class);
    }

    @Test
    void givenNameChangedWithReflection_whenGetName_thenReturnName() throws Exception {
        Class<?> demoClass = Class.forName("com.mockito.testing.privatee.DemoService");
        DemoService mockService = (DemoService) demoClass.getDeclaredConstructor().newInstance();
        Field field = demoClass.getDeclaredField("person");
        field.setAccessible(true);
        field.set(mockService, mockedPerson);

        Mockito.when(mockedPerson.getName()).thenReturn("chen");
        Assertions.assertEquals("chen", mockService.getName());
    }

    @Test
    void givenNameChangedWithReflectionUtils_whenGetName_thenReturnName() throws Exception {
        DemoService mockService = new DemoService();
        Field field = ReflectionUtils.findFields(DemoService.class,
                        f -> f.getName().equals("person"),
                        ReflectionUtils.HierarchyTraversalMode.TOP_DOWN).get(0);
        field.setAccessible(true);
        field.set(mockService, mockedPerson);

        Mockito.when(mockedPerson.getName()).thenReturn("chen");
        Assertions.assertEquals("chen", mockService.getName());
    }
}
