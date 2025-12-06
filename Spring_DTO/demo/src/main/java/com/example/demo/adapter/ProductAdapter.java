package com.example.demo.adapter;

import com.example.demo.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
    public interface ProductAdapter<T>{
        ProductDTO convert(T source);
    }
