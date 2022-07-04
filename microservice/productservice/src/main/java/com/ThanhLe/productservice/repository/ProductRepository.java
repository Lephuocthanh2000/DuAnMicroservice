package com.ThanhLe.productservice.repository;

import com.ThanhLe.productservice.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
    Products findByName(String name);
}
