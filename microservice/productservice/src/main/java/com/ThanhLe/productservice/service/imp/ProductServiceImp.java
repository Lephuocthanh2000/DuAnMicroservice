package com.ThanhLe.productservice.service.imp;

import com.ThanhLe.productservice.model.Products;
import com.ThanhLe.productservice.repository.ProductRepository;
import com.ThanhLe.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Products getByName(String name) {
        Products p = productRepository.findByName(name);
        return p;
    }

    @Override
    public boolean save(Products product) {
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean delete(int id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean update(Products products) {
        productRepository.save(products);
        return true;
    }
}
