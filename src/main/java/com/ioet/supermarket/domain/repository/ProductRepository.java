package com.ioet.supermarket.domain.repository;

import com.ioet.supermarket.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<ProductDto> getAll();
    Optional<List<ProductDto>> getByCategory(int categoryId);
    Optional<List<ProductDto>> getLessStockQuantity(int quantity);
    Optional<ProductDto> getProduct(int productId);
    ProductDto save(ProductDto product);
    void delete(int productId);
}
