package com.ThanhLe.productservice.service.imp;

<<<<<<< HEAD
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
=======
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
>>>>>>> 9b98b3f042f3d16317dbe163f313a3a15888a141
    }
}
