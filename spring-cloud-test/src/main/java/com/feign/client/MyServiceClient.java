package com.feign.client;

import java.util.List;

public class MyServiceClient {

    private final MyServiceFeignClient feignClient;

    public MyServiceClient(MyServiceFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    // 封装feign client的请求，将异常的捕获抛出成自定义的异常类型
    public List<String> getUsersInformation() throws MyServiceException {
        try {
            return feignClient.getInformation();
        } catch (Exception exception) {
            throw new MyServiceException("Feign client error");
        }
    }
}
