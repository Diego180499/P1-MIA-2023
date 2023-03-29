package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EmployeeCrud extends CrudRepository<Employee,String> {

    @Query(value = "SELECT * FROM reporte_empleados_mas_ventas;", nativeQuery = true)
    ArrayList<String> employeeWithMostSales();


    @Query(value = "SELECT * FROM reporte_empleados_mas_ingresos ORDER BY sum DESC;",nativeQuery = true)
    ArrayList<String> employeeWithMostIncome();

}
