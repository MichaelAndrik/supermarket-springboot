package com.ioet.supermarket.persistence.crud;

import com.ioet.supermarket.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    List<Product> findByIdCategory(int idCategory);
    List<Product> findByIdCategoryOrderByNameAsc(int idCategory);
    Optional<List<Product>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);

}
