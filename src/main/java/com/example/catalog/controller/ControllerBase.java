package com.example.catalog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerBase {
    @GetMapping("/add")
    public String addNew(){
        return "add";
    }
}
