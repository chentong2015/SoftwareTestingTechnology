package com.spring.cloud.feign.client;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringFeignClientController {

    private final ProductServiceFeignClient productService;

    // TODO. 自动注入，注入Spring Feign Client bean
    @Autowired
    public SpringFeignClientController(ProductServiceFeignClient productService) {
        this.productService = productService;
    }

    // TODO. 对于ResponseEntity<String>的返回类型，可以提供类似空的ResponseEntity<Void>
    @PostMapping("/products/test/{id}")
    public ResponseEntity<String> testInsertProduct(@PathVariable("id") String id, @RequestBody Product product) {
        try {
            return productService.insertProduct(id, product);
        } catch (FeignException exception) {
            // 这里使用mock掉的productService来抛出异常
            // 进入catch判断条件
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }
}
