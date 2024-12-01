package com.example.catalog.controller;

import com.example.catalog.Product;
import com.example.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class ControllerIndex {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView index(Model model){
        List<Product> allProducts = productService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("products", allProducts);
        return modelAndView;
    }
}
