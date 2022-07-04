package com.ThanhLe.productservice.controller;

import com.ThanhLe.productservice.model.Products;
import com.ThanhLe.productservice.service.ProductService;
import io.tej.SwaggerCodgen.api.ProductApi;
import io.tej.SwaggerCodgen.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProductController implements ProductApi {
    @Autowired
    ProductService productService;

    @Override
    public ResponseEntity<String> _addProduct(Product product) {
        return ResponseEntity.ok("200 ok" + product.getName());
    }

    @PostMapping("/save")
    public boolean saveStudent(@RequestBody(required = true) Products product) {
        return productService.save(product);
    }

    @DeleteMapping()
    public boolean delete(@RequestParam(value = "id", defaultValue = "1") int id) {
        return productService.delete(id);
    }

    @PutMapping("/update")
    public boolean updateStudent(@RequestBody(required = true) Products product) {
        return productService.update(product);
    }
}
