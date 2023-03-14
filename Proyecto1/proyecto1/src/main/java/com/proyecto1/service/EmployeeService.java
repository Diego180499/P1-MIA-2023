package com.proyecto1.service;


import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.employeeDTO.request.NewEmployeeDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;
import com.proyecto1.dto.roleEmployeeDTO.response.RoleEmployeeDTO;
import com.proyecto1.repository.crud.EmployeeCrud;
import com.proyecto1.repository.entity.Employee;
import com.proyecto1.utils.EmployeeUtils;
import com.proyecto1.utils.ProjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeCrud employeeCrud;

    @Autowired
    private BranchService branchService;

    @Autowired
    private EmployeeRoleService employeeRoleService;


    public void saveEmployee(NewEmployeeDTO newEmployee){

        Employee employee = EmployeeUtils.CreateEmployee(newEmployee);
        employeeCrud.save(employee);
    }


    public ArrayList<EmployeeDTO> getAll(){
        ArrayList<Employee> employees = (ArrayList) employeeCrud.findAll();

        ArrayList<EmployeeDTO> employeesDTO = new ArrayList<>();

        for(Employee employee : employees){
            BranchDTO branchDTO = branchService.getById(employee.getBranch());
            RoleEmployeeDTO roleEmployeeDTO = employeeRoleService.getById(employee.getRole());
            EmployeeDTO employeeDTO = EmployeeUtils.EmployeeToEmployeeDTO(employee,branchDTO,roleEmployeeDTO);
            employeesDTO.add(employeeDTO);
        }

        return employeesDTO;
    }


    public EmployeeDTO getByDpi(String dpi){
        Employee employee = employeeCrud.findById(dpi).get();

        BranchDTO branchDTO = branchService.getById(employee.getBranch());
        RoleEmployeeDTO roleEmployeeDTO = employeeRoleService.getById(employee.getRole());
        EmployeeDTO employeeDTO = EmployeeUtils.EmployeeToEmployeeDTO(employee,branchDTO,roleEmployeeDTO);

        return employeeDTO;
    }


    public void modifyEmployee(NewEmployeeDTO newEmployee, String dpi){
        Employee employee = EmployeeUtils.CreateEmployee(newEmployee);

        employeeCrud.save(employee);
    }




}
