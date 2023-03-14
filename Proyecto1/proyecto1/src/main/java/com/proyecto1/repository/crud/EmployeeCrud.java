package com.proyecto1.repository.crud;

import com.proyecto1.repository.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeCrud extends CrudRepository<Employee,String> {
}
