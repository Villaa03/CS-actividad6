package com.salle.avillanueva.productos_backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.salle.avillanueva.productos_backend.model.Product;
import com.salle.avillanueva.productos_backend.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/")
    public Map<String, String> seyHello(){
        return Map.of("message", "Hello, World");
    }
    
    @GetMapping("api/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @PostMapping("api/products")
    public Product createProduct(@RequestBody Product product) {

        var newProduct = productRepository.save(product);
        return newProduct;
    }

}
