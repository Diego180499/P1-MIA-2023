package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface SaleCrud extends CrudRepository<Sale,Integer> {

    @Query(value = "SELECT total FROM venta WHERE id_venta = ?",nativeQuery = true)
    public Integer getSaleTotal(int id);


    //obtener ultima venta de un cliente
    @Query(value = "SELECT total FROM venta WHERE cliente = ? ORDER BY id_venta DESC LIMIT 2;",nativeQuery = true)
    ArrayList<String> getLastSale(String nit);

}
