package com.ioet.supermarket.persistence.mapper;

import com.ioet.supermarket.domain.dto.CategoryDto;
import com.ioet.supermarket.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(source = "idCategory", target = "categoryId")
    @Mapping(source = "description", target = "category")
    @Mapping(source = "status", target = "active")
    CategoryDto toCategoryDto(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    Category toCategoryEntity(CategoryDto category);
}
