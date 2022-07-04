package com.ThanhLe.categoryservice.service.imp;

import com.ThanhLe.categoryservice.model.Category;
import com.ThanhLe.categoryservice.repository.CategoryRepository;
import com.ThanhLe.categoryservice.service.CategoryService;
import io.tej.SwaggerCodgen.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    CategoryRepository cateroryRepository;

    @Override
    public boolean addCaterory(Category category) {
        if(cateroryRepository.findById(category.getIdCategories())!=null){
            return false;
        }
        cateroryRepository.save(category);
        return true;
    }

    @Override
    public Category getByName(String name) {
        return cateroryRepository.findByName(name);
    }



    @Override
    public boolean delete(int id) {
        cateroryRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean update(Category categories) {
        cateroryRepository.save(categories);
        return true;
    }

    @Override
    public List<Category> getAll() {

        return cateroryRepository.findAll();
    }
}
