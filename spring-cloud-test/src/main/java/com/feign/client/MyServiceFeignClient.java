package com.feign.client;

import feign.RequestLine;

import java.util.List;

public interface MyServiceFeignClient {

    @RequestLine("GET /v1/testing/info")
    List<String> getInformation() throws Exception;

}
