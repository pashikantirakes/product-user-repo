package com.example.ProductService.repo;

import com.example.ProductService.entity.Product;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.productName= :name")
    Product getProductByName(@Param("name") String name);
}