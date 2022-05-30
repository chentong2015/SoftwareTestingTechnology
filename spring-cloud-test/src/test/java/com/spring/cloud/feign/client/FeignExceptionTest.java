package com.spring.cloud.feign.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.*;
import org.junit.Assert;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Collections;

// How to mock Feign Client throw exception
// https://github.com/mlk/spring-boot-exceptions-feign/blob/master/src/test/java/com/github/mlk/exceptions/feign/FeignExceptionsTest.java
public class FeignExceptionTest {
    
    public void testMockFeignClient() throws IOException {
        final Client client = Mockito.mock(Client.class);
        ProductServiceFeignClient productServiceFeignClient = Feign.builder()
                .client(client)
                .target(ProductServiceFeignClient.class, "http://testing-url");

        // TODO. 这里直接mock掉Feign Client & Response
        //       
        Request request = Request.create(Request.HttpMethod.POST, "http://testing-url", Collections.emptyMap(), null, Util.UTF_8);
        Mockito.when(client.execute(Mockito.any(Request.class), Mockito.any(Request.Options.class)))
                .thenReturn(Response.builder()
                        .headers(Collections.emptyMap())
                        .request(request)
                        .status(200)
                        .build());

        ObjectMapper mapper = new ObjectMapper();
        Product product = new Product();
        String jsonBody = mapper.writeValueAsString(product);
        // 这里
        productServiceFeignClient.insertProduct("id", product);

        ArgumentCaptor<Request> requestArgumentCaptor = ArgumentCaptor.forClass(Request.class);
        Mockito.verify(client)
                .execute(requestArgumentCaptor.capture(), Mockito.any(Request.Options.class));
        final Request request1 = requestArgumentCaptor.getValue();
        Assert.assertEquals(
                "Unexpected http method used.",
                "POST",
                request1.method()
        );
    }

    public void testMockFeignResponse() {
        //  标准mock FeignException异常的抛出
        //  Response response = Response.builder()
        //         .status(400)
        //         .reason("bad request body")
        //         .headers(Collections.emptyMap())
        //         .request(Request.create(Request.HttpMethod.POST, "/products/test/2", Collections.emptyMap(), null, Util.UTF_8))
        //         .body("Product already exists", StandardCharsets.UTF_8)
        //         .build();
        //
        //  doThrow(FeignException.errorStatus("method key test", response))
        //         .when(productService).testInsertProduct(anyString(), any(Product.class));
    }
}
