package com.example.demo.adapter;

import com.example.demo.dto.ProductDTO;
import com.example.demo.model.ExternalProductResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class ExternalProductAdapter implements ProductAdapter<ExternalProductResponse> {


    @Override
    public ProductDTO convert(ExternalProductResponse response) {
        ProductDTO dto = new ProductDTO();

        dto.setId(Long.parseLong(response.getProductId()));
        dto.setName(response.getTitle());
        dto.setPrice(Double.parseDouble(response.getAmount()));
        return dto;
    }
}
