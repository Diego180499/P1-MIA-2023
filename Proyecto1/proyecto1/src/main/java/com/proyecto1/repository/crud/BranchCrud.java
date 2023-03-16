package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.Branch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BranchCrud extends CrudRepository<Branch, Integer> {

    @Query(value = "SELECT cantidad_productos FROM sucursal WHERE id_sucursal = ?",nativeQuery = true)
    public Integer getStock(int id);

}
