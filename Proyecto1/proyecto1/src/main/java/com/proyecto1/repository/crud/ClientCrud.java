package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ClientCrud extends CrudRepository<Client,String> {

    @Query(value = "SELECT * FROM reporte_clientes_mas_ganancia;",nativeQuery = true)
    ArrayList<String> clientsWithMostIncome();

}
