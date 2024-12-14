package com.example.OrderService.feign;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientEx {
    public WebClient.Builder builder(){
        return (WebClient.Builder) WebClient.builder().build();
    }
}
