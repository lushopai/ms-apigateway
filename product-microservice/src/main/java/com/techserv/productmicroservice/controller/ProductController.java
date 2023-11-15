package com.techserv.productmicroservice.controller;

import com.techserv.productmicroservice.entity.Product;
import com.techserv.productmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(){
        return productRepository.findAll();

    }

    @PostMapping("/save")
    public Product createProduct(@RequestBody Product request){
        return productRepository.save(request);
    }
}
