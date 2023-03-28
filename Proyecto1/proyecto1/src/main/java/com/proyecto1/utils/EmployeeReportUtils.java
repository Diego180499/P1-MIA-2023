package com.proyecto1.utils;

import com.proyecto1.dto.reportsDTO.employeeReportDTO.EmployeeWithMostIncomeDTO;
import com.proyecto1.dto.reportsDTO.employeeReportDTO.EmployeeWithMostSalesDTO;

import java.util.ArrayList;

public class EmployeeReportUtils {

    public static ArrayList<EmployeeWithMostSalesDTO> employeeWithMostSales(ArrayList<String> employees){
        ArrayList<EmployeeWithMostSalesDTO> employeesDTO = new ArrayList<>();

        for(int i=0; i<employees.size(); i++){
            String data [] = employees.get(i).split(",");
            EmployeeWithMostSalesDTO employee = new EmployeeWithMostSalesDTO();
            employee.setDpi(data[0]);
            employee.setName(data[1]);
            employee.setLastName(data[2]);
            employee.setSalesAmount(Integer.parseInt(data[3]));
            employeesDTO.add(employee);
        }
        return employeesDTO;
    }

    public static ArrayList<EmployeeWithMostIncomeDTO> employeeWithMostIncome(ArrayList<String> employees){
        ArrayList<EmployeeWithMostIncomeDTO> employeesDTO = new ArrayList<>();

        for(int i=0; i<employees.size(); i++){
            String data [] = employees.get(i).split(",");
            EmployeeWithMostIncomeDTO employee = new EmployeeWithMostIncomeDTO();
            employee.setDpi(data[0]);
            employee.setName(data[1]);
            employee.setLastName(data[2]);
            employee.setIncome(Integer.parseInt(data[3]));
            employeesDTO.add(employee);
        }
        return employeesDTO;
    }


}
