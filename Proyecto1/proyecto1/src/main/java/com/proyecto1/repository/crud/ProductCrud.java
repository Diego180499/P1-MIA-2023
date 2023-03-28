package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ProductCrud extends CrudRepository<Product, Integer> {

    //Reportes sobre productos

    //Top 10 productos mas vendidos
    @Query(value = "SELECT * FROM reporte_productos_mas_vendidos ORDER BY sum desc;",nativeQuery = true)
    ArrayList<String> mostSelledProducts();

    /*Top productos con mas ingresos*/
    @Query(value = "SELECT * FROM reporte_productos_mas_ingresos ORDER BY sum DESC;",nativeQuery = true)
    ArrayList<String> productsWithMostIncome();

    /*Top 5 productos mas vendidos por sucursal*/
    @Query(value = "SELECT * FROM vista_productos_mas_vendidos_sucursal WHERE id_sucursal = ? ORDER BY sum DESC;",nativeQuery = true)
    ArrayList<String> mostSelledProductsByBranch(int idSucursal);

    /*Top 5 productos mas ingresos por sucursal*/
    @Query(value = "SELECT * FROM reporte_productos_mas_ingresos_sucursal WHERE id_sucursal = ? ORDER BY sum DESC;", nativeQuery = true)
    ArrayList<String> productsWithMostIncomebySucursal(int idSucursal);



}
