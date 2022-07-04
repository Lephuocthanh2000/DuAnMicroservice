package com.ThanhLe.productservice.service;

import com.ThanhLe.productservice.model.Products;

public interface ProductService {
    Products getByName(String name);
    boolean save(Products product);
    boolean delete(int id);
    boolean update(Products products);
}
