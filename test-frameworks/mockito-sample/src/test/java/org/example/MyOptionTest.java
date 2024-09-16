package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.mockito.Mockito.mockStatic;

public class MyOptionTest {

    private MockedStatic<MyOption> mockInstance;

    // 直接Mock掉类型的静态方法
    // @Test
    // public void testMockStatic() {
    //     MyOption myOption = new MyOption("my option");
    //     mockInstance = mockStatic(MyOption.class);
    //     mockInstance.when(MyOption::getInstance).thenReturn(myOption);
//
    //     Assert.assertEquals("Instance", MyOption.getInstance().getName());
    // }
//
    // @Test
    // public void testMockStatic2() {
    //     MyOption myOption = new MyOption("my option");
    //     try(MockedStatic<MyOption> mockInstance = mockStatic(MyOption.class)) {
    //         mockInstance.when(MyOption::getInstance).thenReturn(myOption);
    //         Assert.assertEquals("my option", MyOption.getInstance().getName());
    //     }
    // }
//
    // //  The returned object's MockedStatic.close() method must be called upon completing the test
    // //  or the mock will remain active on the current thread.
    // @Test
    // public void testMockStatic3() {
    //     MyOption myOption = new MyOption("my option");
    //     MockedStatic<MyOption> mockInstance = mockStatic(MyOption.class);
    //     mockInstance.when(MyOption::getInstance).thenReturn(myOption);
    //     Assert.assertEquals("my option", MyOption.getInstance().getName());
//
    // }
//
    // @After
    // public void closeMockInstance() {
    //     if (mockInstance != null) {
    //         mockInstance.close();
    //     }
    // }

}
