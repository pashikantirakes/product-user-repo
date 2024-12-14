package com.example.ProductService.dto;

public class ProductResponse {
    private Long id;
    private String productName;
    private String username;
    private int cost;
    private int age;

    public ProductResponse(){}
    public ProductResponse(Long id, String productName, String username, int cost, int age) {
        this.id = id;
        this.productName = productName;
        this.username = username;
        this.cost = cost;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
