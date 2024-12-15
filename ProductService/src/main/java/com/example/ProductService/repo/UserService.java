package com.example.ProductService.repo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserServiceWithGateWay",url = "http://localhost:8085/user")
public interface UserService {

    @GetMapping("/get/{name}")
    @CircuitBreaker(name = "User-Circuit-Breaker" , fallbackMethod = "fallbackResponse")
    public ResponseEntity<User> getUserByName(@PathVariable String name);

    public default ResponseEntity<User> fallbackResponse(){
        User user = new User();
        user.setId(0l);
        user.setName(" ");
        user.setAge(0);
        return ResponseEntity.ok(user);

    }
}
