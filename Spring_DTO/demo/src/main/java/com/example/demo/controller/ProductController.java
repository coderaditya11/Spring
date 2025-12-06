package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping("/db/{id}")
    public ProductDTO fromDb(@PathVariable Long id) {
        return service.getFromDb(id);
    }
    @GetMapping("/external")
    public ProductDTO fromExternal() {
        return service.getFromExternal();
    }
}
