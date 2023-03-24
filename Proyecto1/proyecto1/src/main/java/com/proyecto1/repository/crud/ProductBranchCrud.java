package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.ProductBranch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProductBranchCrud extends CrudRepository<ProductBranch, String> {

    @Query(value = "SELECT * FROM producto_sucursal WHERE sucursal = ?;",nativeQuery = true)
    ArrayList<ProductBranch> getBySucursal(int idSucursal);


    //obtener el stock
    @Query(value = "SELECT cantidad_stock FROM producto_sucursal WHERE id_producto_sucursal = ?",nativeQuery = true)
    public Integer getStock(String id);

}
