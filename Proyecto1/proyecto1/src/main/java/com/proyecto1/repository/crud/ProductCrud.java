package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrud extends CrudRepository<Product, Integer> {

}
