package com.example.catalog.controller;

import com.example.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerBase {



    @GetMapping("/add")
    public String addNew(){
        return "add";
    }

}
