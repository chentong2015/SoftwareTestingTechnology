package com.spring.cloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// TODO. 注意
//  1. 在初始化构建的时候，这里的feign client必须要能够构建出来，必须设置url
//     否则会抛出Failed to load ApplicationContext异常
//  2. 可以mock掉ProductService Feign Client，mock throw exception 则无需url
@FeignClient(value = "product-service", url = "http://localhost:5679/")
public interface ProductServiceFeignClient {

    // 这里和要发送请求的Service Controller的方法一致
    @PostMapping(value = "/products/{id}", consumes = "application/json;charset=UTF-8")
    ResponseEntity<String> insertProduct(@PathVariable("id") String id, @RequestBody Product product);

    // TODO. 但这里的方法可能抛出FeignException异常，被调用它的方法所捕获
    //       异常携带的是请求的server上的(非200)对于的错误信息 !!
    @PostMapping(value = "/products/test/{id}", consumes = "application/json;charset=UTF-8")
    ResponseEntity<String> testInsertProduct(@PathVariable("id") String id, @RequestBody Product product);
}
