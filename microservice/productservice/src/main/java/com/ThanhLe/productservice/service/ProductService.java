package com.ThanhLe.productservice.service;

import com.ThanhLe.productservice.model.Products;

public interface ProductService {
<<<<<<< HEAD
    Products getById(int id);
=======
    Products getByName(String name);
    boolean save(Products product);
    boolean delete(int id);
    boolean update(Products products);
>>>>>>> 9b98b3f042f3d16317dbe163f313a3a15888a141
}
