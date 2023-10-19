package com.powermock.testing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MyPowermockClass.class})
public class MyPowermockTest {

    // 1. Mock final class

    // 2. Mock constructor
    public void testMockConstructor() throws Exception {
        MyPowermockClass myPowermockClass = PowerMockito.mock(MyPowermockClass.class);
        PowerMockito.whenNew(MyPowermockClass.class).withArguments("name").thenReturn(myPowermockClass);
    }

    // 3. Mock private methods
    @Test
    public void testMockPrivateMethod() throws Exception {
        MyPowermockClass mockClass = PowerMockito.spy(new MyPowermockClass("name"));
        // mock指定名称的私有方法, 支持传递私有方法的参数
        PowerMockito.doReturn("private: test").when(mockClass, "getNamePrivate", "test");
        // 验证mock掉的private method被调用, 只能通过类中被的方法来调用 !!
        Assertions.assertEquals("private: test", mockClass.callPrivateMethod("test"));
    }

    // 4. Mock static methods
    @Test
    public void testMockStaticMethod() {
        PowerMockito.mockStatic(MyPowermockClass.class);
        PowerMockito.when(MyPowermockClass.getNameStatic("test")).thenReturn("static: ok");
        Assert.assertEquals("static: ok", MyPowermockClass.getNameStatic("test"));

        // 低版本的通过该方式来验证是否静态方法被调用
        // PowerMockito.verifyStatic();
        // MyPowermockClass.getNameStatic("test")
    }

    // 5. Mock final methods
}
