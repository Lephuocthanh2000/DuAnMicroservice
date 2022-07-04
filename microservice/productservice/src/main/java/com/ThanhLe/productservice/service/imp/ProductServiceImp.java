package com.ThanhLe.productservice.service.imp;

import com.ThanhLe.productservice.model.Categories;
import com.ThanhLe.productservice.model.Products;
import com.ThanhLe.productservice.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImp {
    @Autowired
    ProductRepository productRepository;
    @Autowired ApiCall apiCall;
    @Override
    public Products getById(int id) {
        // getting student from table by passing id
        Products p = productRepository.findById(id).orElse(null);

        //getting course from course microservice by call API
        Categories categories = apiCall.getCourseDetails(p.getCategoryId());

        Products pr = new Products();
        BeanUtils.copyProperties(p, pr);
        pr.setCategoriesId(categories);
        return pr;
    }
}
