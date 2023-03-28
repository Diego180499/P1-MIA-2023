package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.Branch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BranchCrud extends CrudRepository<Branch, Integer> {

    @Query(value = "SELECT cantidad_productos FROM sucursal WHERE id_sucursal = ?",nativeQuery = true)
    public Integer getStock(int id);

    /* Reports */

    @Query(value = "SELECT * FROM reporte_sucursales_mas_ventas;",nativeQuery = true)
    ArrayList<String> branchWithMostSales();

    @Query(value = "SELECT * FROM reporte_sucursales_mas_ganancia;",nativeQuery = true)
    ArrayList<String> branchWithMostIncome();

}
