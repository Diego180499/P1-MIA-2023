package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.ProductBranch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductBranchCrud extends CrudRepository<ProductBranch, String> {

    //modificar el stock de un producto en una sucursal
    @Query(value = "UPDATE producto_sucursal SET cantidad_stock = ? WHERE id_producto_sucursal = ? ;",nativeQuery = true)
    public void modifyStock(int stock, String productBranchId);


    //obtener el stock
    @Query(value = "SELECT cantidad_stock FROM producto_sucursal WHERE id_producto_sucursal = ?",nativeQuery = true)
    public Integer getStock(String id);

}
