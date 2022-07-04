package com.ThanhLe.categoryservice.controller;

import com.ThanhLe.categoryservice.service.CategoryService;
import io.tej.SwaggerCodgen.api.CategoriesApi;
import io.tej.SwaggerCodgen.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController  {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/test")
    public String Test(){
        return "test successfull";
    }
//    @Override
//    public ResponseEntity<List <Categories> > getCategories() {
//        return categoryService.getAll();
//    }
}
