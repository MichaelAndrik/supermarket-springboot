package com.ioet.supermarket.persistence;

import com.ioet.supermarket.domain.dto.ProductDto;
import com.ioet.supermarket.domain.repository.ProductRepository;
import com.ioet.supermarket.persistence.crud.ProductCrudRepository;
import com.ioet.supermarket.persistence.entity.Product;
import com.ioet.supermarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByIdCategory(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<ProductDto>> getLessStockQuantity(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<ProductDto> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProductDto(product));
    }

    @Override
    public ProductDto save(ProductDto product) {
        Product productMapped = mapper.toProductEntity(product);
        return mapper.toProductDto(productCrudRepository.save(productMapped));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
