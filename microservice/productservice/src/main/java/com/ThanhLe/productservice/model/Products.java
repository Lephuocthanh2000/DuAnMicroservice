package com.ThanhLe.productservice.model;

import io.tej.SwaggerCodgen.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Products  {
    @Id
    Integer id;
    String name;
}
