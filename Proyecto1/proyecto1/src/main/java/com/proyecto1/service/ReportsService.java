package com.proyecto1.service;

import com.proyecto1.dto.reportsDTO.branchReportDTO.BranchWithMostIncomeDTO;
import com.proyecto1.dto.reportsDTO.branchReportDTO.BranchWithMostSalesDTO;
import com.proyecto1.dto.reportsDTO.clientReportDTO.ClientWithMoreIncomeDTO;
import com.proyecto1.dto.reportsDTO.employeeReportDTO.EmployeeWithMostIncomeDTO;
import com.proyecto1.dto.reportsDTO.employeeReportDTO.EmployeeWithMostSalesDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.MostIncomeWithBranchDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.MostSelledByBranchDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.MostSelledProductDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.ProductsWithMostIncomeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReportsService {


    @Autowired
    private ProductService productService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private BranchService branchService;
    @Autowired
    EmployeeService employeeService;


    /* PRODUCTS REPORTS */

    public ArrayList<MostSelledProductDTO> mostSelledProducts(){
        return productService.mostSelledProducts();
    }


    public ArrayList<ProductsWithMostIncomeDTO> productsWithMostIncome(){
        return productService.productsWithMostIncome();
    }


    public ArrayList<MostSelledByBranchDTO> mostSalledByBranch(int idSucursal){
        return productService.mostSelledByBranch(idSucursal);
    }

    public ArrayList<MostIncomeWithBranchDTO> mostIncomebySucursal(int idSucursal){
        return productService.mostIncomebySucursal(idSucursal);
    }

    /* CLIENT REPORTS */

    public ArrayList<ClientWithMoreIncomeDTO> clientWithMostIncome(){
       return clientService.clientWithMostIncome();
    }


    /* BRANCH REPORTS */
    public ArrayList<BranchWithMostSalesDTO> branchWithMostSales(){
       return branchService.branchWithMostSales();
    }

    public ArrayList<BranchWithMostIncomeDTO> branchWithMostIncome(){
      return  branchService.branchWithMostIncome();
    }

    /* EMPLOYEE REPORTS */
    public ArrayList<EmployeeWithMostSalesDTO> employeeWithMostSales(){
      return employeeService.employeeWithMostsales();
    }

    public ArrayList<EmployeeWithMostIncomeDTO> employeeWithMostIncome(){
       return employeeService.employeeWithMostIncome();
    }

}
