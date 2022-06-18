package mock.powermock;

import com.testing.others.mock.MyServiceUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mockStatic;

// TODO. PowerMock更强大的Mock测试
// 1. Mock constructor
// 2. Mock final class
// 3. Mock final methods
// 4. Mock static methods
@RunWith(PowerMockRunner.class)
@PrepareForTest({MyServiceUtil.class})
public class PowerMockitoTest {

    @Test
    public void test_get_service_url() {
        mockStatic(MyServiceUtil.class);
        PowerMockito.when(MyServiceUtil.getStaticServiceUrl("localhost")).thenReturn("localhost:8080");
        Assert.assertEquals("localhost:8080", MyServiceUtil.getStaticServiceUrl("localhost"));
    }
}
