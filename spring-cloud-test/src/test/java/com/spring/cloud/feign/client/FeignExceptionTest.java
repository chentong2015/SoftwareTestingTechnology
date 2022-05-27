package com.spring.cloud.feign.client;

// How to mock Feign Client throw exception
// https://github.com/mlk/spring-boot-exceptions-feign/blob/master/src/test/java/com/github/mlk/exceptions/feign/FeignExceptionsTest.java
public class FeignExceptionTest {

    // byte[] responseBody = "Counterparty already exists".getBytes();
    // Request request = Request.create(Request.HttpMethod.POST,"/v1/examples/tests",
    //         Collections.emptyMap(), Request.Body.encoded(content, StandardCharsets.UTF_8));
    // Mockito.when(serviceMock.insertCounterparty(any(Counterparty.class))).thenThrow(
    //         FeignException.errorStatus("", Response.builder().request(request).status(400).body(responseBody).build())
    // );
}
