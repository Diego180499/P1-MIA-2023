package com.proyecto1.utils;

import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.employeeDTO.request.NewEmployeeDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;
import com.proyecto1.dto.roleEmployeeDTO.response.RoleEmployeeDTO;
import com.proyecto1.repository.entity.Employee;

import java.util.Date;

public class EmployeeUtils {



    public static EmployeeDTO EmployeeToEmployeeDTO(Employee employee,BranchDTO branchDTO,RoleEmployeeDTO roleEmployeeDTO){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setDpi(employee.getDpi());
        employeeDTO.setName(employee.getName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setBirhtDate(employee.getBirthDate());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setBranchDTO(branchDTO);
        employeeDTO.setRoleEmployeeDTO(roleEmployeeDTO);

        return employeeDTO;
    }

    public static Employee CreateEmployee(NewEmployeeDTO newEmployee){
        Employee employee = new Employee();
        Date birthDate = ProjectUtils.StringToDate(newEmployee.getBirthDate(),"dd/MM/yyyy");
        employee.setDpi(newEmployee.getDpi());
        employee.setName(newEmployee.getName());
        employee.setLastName(newEmployee.getLastName());
        employee.setBirthDate(birthDate);
        employee.setPhone(newEmployee.getPhone());
        employee.setBranch(newEmployee.getBranch());
        employee.setRole(newEmployee.getRole());
        employee.setSalary(newEmployee.getSalary());
        return employee;
    }



}
