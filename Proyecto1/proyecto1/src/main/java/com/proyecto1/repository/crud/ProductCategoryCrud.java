package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryCrud extends CrudRepository<ProductCategory, Integer> {
}
