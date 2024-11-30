package com.example.catalog.controller;

import com.example.catalog.Product;
import com.example.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //Output Json
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable Long id) {
//        return productService.getProductById(id);
//    }
    @GetMapping("/{id}")
    public ModelAndView getProductById(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("item");
        model.addAttribute("product", Map.of("id", id, "name", product.getName()));
        return modelAndView;
    }

}