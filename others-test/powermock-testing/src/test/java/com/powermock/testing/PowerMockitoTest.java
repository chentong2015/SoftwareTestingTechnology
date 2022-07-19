package com.powermock.testing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

// TODO. PowerMock更强大的Mock测试
// 1. 是否需要同时提供api和modules两种项目依赖 ?
// 2. 如何解决WARNING: An illegal reflective access operation has occurred ?
// 3. 如何验证mock的方法被调用了 ?

// https://www.javatpoint.com/mockito-powermock
// https://www.softwaretestinghelp.com/mock-private-static-void-methods-mockito/#:~:text=For%20Mockito%2C%20there%20is%20no,to%20avoid%20static%2Ffinal%20methods.
@RunWith(PowerMockRunner.class)
@PrepareForTest({MyServiceUtil.class})
public class PowerMockitoTest {

    // 1. Mock constructor

    // 2. Mock private methods

    // 3. Mock static methods
    @Test
    public void test_get_service_url() {
        PowerMockito.mockStatic(MyServiceUtil.class);
        PowerMockito.when(MyServiceUtil.getStaticServiceUrl("localhost"))
                .thenReturn("localhost:8080");
        String result = MyServiceUtil.getStaticServiceUrl("localhost");
        Assert.assertEquals("localhost:8080", result);

        //
        // PowerMockito.verifyStatic(MyServiceUtil.class);
    }

    // 4. Mock final class

    // 5. Mock final methods
}
