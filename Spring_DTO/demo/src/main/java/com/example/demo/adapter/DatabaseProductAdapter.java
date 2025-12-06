package com.example.demo.adapter;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class DatabaseProductAdapter implements ProductAdapter<ProductEntity> {
    @Override
    public ProductDTO convert(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getProductName());
        dto.setPrice(entity.getProductCost());
        return dto;
    }
}
