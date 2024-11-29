package com.example.catalog.controller;

import com.example.catalog.Product;
import com.example.catalog.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add-new")
public class ProductController2 {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String addProduct(@RequestParam("name") String name) {
        LOGGER.info("Received request for adding a new product: {}", name);

        try {
            // Process the request
            Product product = new Product(name);
            productService.addProduct(product);
            return "Product created successfully!";
        } catch (Exception e) {
            LOGGER.error("Error creating product:", e);
            return "Error creating product: " + e.getMessage();
        }
    }

    private Logger LOGGER = LoggerFactory.getLogger(ProductController2.class);
}
