package com.example.catalog.controller;

import com.example.catalog.Product;
import com.example.catalog.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/add-new")
public class ProductController2 {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ModelAndView addProduct(@RequestParam("name") String name, Model model) {
        LOGGER.info("Received request for adding a new product: {}", name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addNewViews");
        try {
            // Process the request
            Product product = new Product(name);
            productService.addProduct(product);
            long id = product.getId();
            model.addAttribute("product", Map.of("name", name, "id", id , "message", "Success!"));
            // Render the addNewView template with the product data
            return modelAndView;
        } catch (Exception e) {
            LOGGER.error("Error creating product:", e);
            model.addAttribute("message", "Not saved");
            // Render the errorView template with an error message
            return modelAndView;
        }
    }

    private Logger LOGGER = LoggerFactory.getLogger(ProductController2.class);
}
