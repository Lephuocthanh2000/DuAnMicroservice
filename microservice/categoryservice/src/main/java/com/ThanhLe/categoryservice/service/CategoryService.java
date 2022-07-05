package com.ThanhLe.categoryservice.service;

import com.ThanhLe.categoryservice.model.Category;
import io.tej.SwaggerCodgen.model.Categories;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    boolean addCaterory(Category category);
    Category getByName(String name);
    boolean delete(int id);
    boolean update(Category categories);

    List<Category> getAll();
}
