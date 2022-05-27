package com.spring.cloud.feign.client;

// How to mock Feign Client throw exception
// https://github.com/mlk/spring-boot-exceptions-feign/blob/master/src/test/java/com/github/mlk/exceptions/feign/FeignExceptionsTest.java
public class FeignExceptionTest {

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
