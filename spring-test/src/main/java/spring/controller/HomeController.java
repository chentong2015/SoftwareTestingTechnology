package spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.datamodel.MyClass;

@RestController
public class HomeController {

    @GetMapping("/index")
    public String index() {
        return "Index Page";
    }
    
    @PostMapping("/post")
    public ResponseEntity<String> post(@RequestBody MyClass myClass) {
        String result = myClass.getStatus() != null ? "OK" : "Error";
        return ResponseEntity.ok(result);
    }
}
