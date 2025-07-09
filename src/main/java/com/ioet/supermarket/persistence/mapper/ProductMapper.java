package com.ioet.supermarket.persistence.mapper;

import com.ioet.supermarket.domain.dto.ProductDto;
import com.ioet.supermarket.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mapping(source = "idProduct", target = "productId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "idCategory", target = "categoryId")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "stockQuantity", target = "stock")
    @Mapping(source = "status", target = "active")
    @Mapping(source = "category", target = "category")
    ProductDto toProductDto(Product product);
    List<ProductDto> toProducts(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barcode", ignore = true)
    Product toProductEntity(ProductDto product);
}
