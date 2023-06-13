package com.codingcomrades.CEM_fullstack.controller;

import com.codingcomrades.CEM_fullstack.exception.InvoiceNotFoundException;
import com.codingcomrades.CEM_fullstack.model.Product;

import com.codingcomrades.CEM_fullstack.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")

public class ProductController {
    @Autowired

    private ProductRepository productRepository;
    @PostMapping("/product")
    Product newProduct(@RequestBody Product newProduct){

        return productRepository.save(newProduct);
    }

    @GetMapping("/products")
    List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    @GetMapping("/product/{Id}")
    public Product getProduct(@PathVariable Long Id) {

        return productRepository.findById(Id).orElse(null);
    }



}
