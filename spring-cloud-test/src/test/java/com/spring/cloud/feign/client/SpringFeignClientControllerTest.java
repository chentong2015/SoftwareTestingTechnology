package com.spring.cloud.feign.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class SpringFeignClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // TODO. Spring FeignClient的mock必须使用.thenAnswer()来设置返回的ResponseEntity !!
    @Test
    void testInsertProductWithExceptionAndResponseBody() throws Exception {
        byte[] content = getRequestBodyContent();
        ProductService productService = Mockito.mock(ProductService.class);
        Mockito.when(productService.testInsertProduct(anyString(), any(Product.class)))
                .thenAnswer(invocationOnMock ->
                        new ResponseEntity<>("Product already exists", HttpStatus.BAD_REQUEST)
                );

        mockMvc.perform(post("/products/test/2")
                        .content(content)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string("Product already exists"));
    }

    private byte[] getRequestBodyContent() throws JsonProcessingException {
        // Resource resource = new ClassPathResource("products.json");
        // FileInputStream file = new FileInputStream(resource.getFile());
        // byte[] content = ByteStreams.toByteArray(file);

        Product product = new Product();
        product.setId("2");
        product.setName("test");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(product);
        byte[] content = json.getBytes();
        return content;
    }
}