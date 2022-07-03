package com.ThanhLe.productservice.controller;

import com.ThanhLe.productservice.model.Products;
import io.tej.SwaggerCodgen.api.ProductApi;
import io.tej.SwaggerCodgen.model.Product;
import org.springframework.http.ResponseEntity;


public class ProductController implements ProductApi {
    @Override
    public ResponseEntity<String> _addProduct(Product product){
        return ResponseEntity.ok("200 ok"+product.getName());
    }
}
