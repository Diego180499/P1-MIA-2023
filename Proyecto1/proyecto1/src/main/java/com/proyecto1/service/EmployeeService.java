package com.proyecto1.service;


import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.employeeDTO.request.NewEmployeeDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeCreatedDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;
import com.proyecto1.dto.reportsDTO.employeeReportDTO.EmployeeWithMostIncomeDTO;
import com.proyecto1.dto.reportsDTO.employeeReportDTO.EmployeeWithMostSalesDTO;
import com.proyecto1.dto.roleEmployeeDTO.response.RoleEmployeeDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.repository.crud.EmployeeCrud;
import com.proyecto1.repository.entity.Employee;
import com.proyecto1.utils.EmployeeReportUtils;
import com.proyecto1.utils.EmployeeUtils;
import com.proyecto1.utils.ProjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

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


    public EmployeeCreatedDTO saveEmployee(NewEmployeeDTO newEmployee) throws MarketException {
        validateData(newEmployee);
        Employee employee = EmployeeUtils.CreateEmployee(newEmployee);
        BranchDTO branchDTO = branchService.getById(employee.getBranch());
        RoleEmployeeDTO roleEmployeeDTO = employeeRoleService.getById(employee.getRole());
        EmployeeDTO employeeDTO = EmployeeUtils.EmployeeToEmployeeDTO(employee,branchDTO,roleEmployeeDTO);
        employeeCrud.save(employee);
        EmployeeCreatedDTO employeeCreatedDTO = new EmployeeCreatedDTO();
        employeeCreatedDTO.setEmployee(employeeDTO);
        employeeCreatedDTO.setStatus(201);
        return employeeCreatedDTO;
    }

    public ArrayList<EmployeeDTO> getAll() throws MarketException {
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


    public EmployeeDTO getByDpi(String dpi) throws MarketException {
        if(!employeeCrud.existsById(dpi)){
            throw new MarketException("El empleado no existe",404);
        }

        Employee employee = employeeCrud.findById(dpi).get();

        BranchDTO branchDTO = branchService.getById(employee.getBranch());
        RoleEmployeeDTO roleEmployeeDTO = employeeRoleService.getById(employee.getRole());
        EmployeeDTO employeeDTO = EmployeeUtils.EmployeeToEmployeeDTO(employee,branchDTO,roleEmployeeDTO);

        return employeeDTO;
    }


    public EmployeeCreatedDTO modifyEmployee(NewEmployeeDTO newEmployee, String dpi) throws MarketException {
        if(!employeeCrud.existsById(dpi)){
            throw new MarketException("El empleado no existe",404);
        }

        Employee employee = EmployeeUtils.CreateEmployee(newEmployee);
        BranchDTO branchDTO = branchService.getById(employee.getBranch());
        RoleEmployeeDTO roleEmployeeDTO = employeeRoleService.getById(employee.getRole());
        EmployeeDTO employeeDTO = EmployeeUtils.EmployeeToEmployeeDTO(employee,branchDTO,roleEmployeeDTO);
        employeeCrud.save(employee);
        EmployeeCreatedDTO employeeCreatedDTO = new EmployeeCreatedDTO();
        employeeCreatedDTO.setEmployee(employeeDTO);
        employeeCreatedDTO.setStatus(201);
        return employeeCreatedDTO;
    }

    //Private methods ***
    private void validateData(NewEmployeeDTO newEmployee) throws MarketException {

        if(employeeCrud.existsById(newEmployee.getDpi())){
            throw new MarketException("El empleado con el dpi "+newEmployee.getDpi()+" ya ha sido registrado", 400);
        }

        if(!branchService.exist(newEmployee.getBranch())){
            throw new MarketException("La sucursal solicitada no existe", 404);
        }

        if(!employeeRoleService.exist(newEmployee.getRole())){
            throw new MarketException("El rol solicitado no existe", 404);
        }

    }

    public Boolean exist(String dpi){
        return employeeCrud.existsById(dpi);
    }

    /*REPORTS*/
    public ArrayList<EmployeeWithMostSalesDTO> employeeWithMostsales(){
        ArrayList<String> employees = employeeCrud.employeeWithMostSales();
        ArrayList<EmployeeWithMostSalesDTO> employeesDTO = EmployeeReportUtils.employeeWithMostSales(employees);
        return employeesDTO;
    }

    public ArrayList<EmployeeWithMostIncomeDTO> employeeWithMostIncome(){
        ArrayList<String> employees = employeeCrud.employeeWithMostIncome();
        ArrayList<EmployeeWithMostIncomeDTO> employeesDTO = EmployeeReportUtils.employeeWithMostIncome(employees);
        return employeesDTO;
    }

}
