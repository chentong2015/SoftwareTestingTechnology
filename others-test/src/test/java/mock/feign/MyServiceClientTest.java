package mock.feign;

import com.testing.others.mock.feign.MyServiceClient;
import com.testing.others.mock.feign.MyServiceException;
import com.testing.others.mock.feign.MyServiceFeignClient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import java.util.List;

public class MyServiceClientTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        // TODO. 注意：高版本的Mockito是没有这个方法的，需要直接mock掉interface
        // MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_feign_client_successfully() throws Exception {
        MyServiceFeignClient feignClient = Mockito.mock(MyServiceFeignClient.class);
        List<String> values = List.of("item1", "item2");
        Mockito.doReturn(values).when(feignClient).getInformation();
        MyServiceClient myServiceClient = new MyServiceClient(feignClient);

        Assert.assertEquals(values, myServiceClient.getUsersInformation());
    }

    @Test
    public void test_feign_client_with_exception() throws Exception {
        MyServiceFeignClient feignClient = Mockito.mock(MyServiceFeignClient.class);
        Mockito.doThrow(new Exception("exception")).when(feignClient).getInformation();
        MyServiceClient myServiceClient = new MyServiceClient(feignClient);

        // 这里验证异常类型的抛出和异常的信息
        expectedException.expect(MyServiceException.class);
        expectedException.expectMessage("Feign client error");
        myServiceClient.getUsersInformation();
    }
}
