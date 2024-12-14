package com.example.ProductService.rest;

import com.example.ProductService.dto.ProductRequest;
import com.example.ProductService.dto.ProductResponse;
import com.example.ProductService.entity.Product;
import com.example.ProductService.repo.ProductRepository;
import com.example.ProductService.repo.User;
import com.example.ProductService.repo.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository repository;
    private final UserService userService;
    private final ModelMapper mapper;

    public ProductController(ProductRepository pr,UserService userService,ModelMapper mapper){
        this.repository=pr;
        this.userService=userService;
        this.mapper=mapper;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product>getProductByName(@PathVariable String name){
        return new ResponseEntity<>(repository.getProductByName(name), HttpStatus.OK);
    }

    @PostMapping("/save")

    //@Retry(name = "productRetry",fallbackMethod = "fallbackResponse")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest product){
        ProductResponse pr = new ProductResponse();
       ResponseEntity<User> user = userService.getUserByName(product.userName());
        if(user!= null) {
           Optional <User> newUSer = Optional.ofNullable(user.getBody());
            if(newUSer.isPresent()) {
                pr.setId(product.id());
                pr.setProductName(product.productName());
                pr.setCost(product.cost());
                pr.setUsername(product.userName());
                pr.setAge(newUSer.get().getAge());

                repository.save(mapper.map(pr, Product.class));
            }
        }
        return new ResponseEntity<>(pr, HttpStatus.OK);
    }


}
