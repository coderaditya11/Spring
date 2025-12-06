package com.example.demo.service;

import com.example.demo.adapter.DatabaseProductAdapter;
import com.example.demo.adapter.ExternalProductAdapter;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.ProductEntity;
import com.example.demo.model.ExternalProductResponse;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;
    private final DatabaseProductAdapter dbAdapter;
    private final ExternalProductAdapter externalAdapter;

    public ProductService(ProductRepository repo,
                          DatabaseProductAdapter dbAdapter,
                          ExternalProductAdapter externalAdapter) {

        this.repo = repo;
        this.dbAdapter = dbAdapter;
        this.externalAdapter = externalAdapter;
    }

    public ProductDTO getFromDb(Long id){
        ProductEntity entity =repo.findById(id)
        .orElseThrow(() -> new RuntimeException("Product not found"));

        return dbAdapter.convert(entity);
    }

    public ProductDTO getFromExternal() {
        ExternalProductResponse resp = new ExternalProductResponse();
        resp.setProductId("101");
        resp.setTitle("External Charger");
        resp.setAmount("999.99");
        return externalAdapter.convert(resp);
    }


}
