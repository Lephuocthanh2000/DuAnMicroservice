package com.ThanhLe.productservice.repository;

<<<<<<< HEAD
public interface ProductRepository {
=======
import com.ThanhLe.productservice.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
    Products findByName(String name);
>>>>>>> 9b98b3f042f3d16317dbe163f313a3a15888a141
}
