package com.proyecto1.controllers;

import com.proyecto1.dto.reportsDTO.branchReportDTO.BranchWithMostIncomeDTO;
import com.proyecto1.dto.reportsDTO.branchReportDTO.BranchWithMostSalesDTO;
import com.proyecto1.dto.reportsDTO.clientReportDTO.ClientWithMoreIncomeDTO;
import com.proyecto1.dto.reportsDTO.employeeReportDTO.EmployeeWithMostIncomeDTO;
import com.proyecto1.dto.reportsDTO.employeeReportDTO.EmployeeWithMostSalesDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.MostIncomeWithBranchDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.MostSelledByBranchDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.MostSelledProductDTO;
import com.proyecto1.dto.reportsDTO.productReportDTO.ProductsWithMostIncomeDTO;
import com.proyecto1.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/reports")
public class ReportsController {


    @Autowired
    private ReportsService reportsService;

    /*All about PRODUCTS reports*/

    @CrossOrigin(origins = "http://127.0.0.1:5500")
        @GetMapping("/mostSelledProduct")
        public ResponseEntity<ArrayList<MostSelledProductDTO>> mostSelledProduct(){
            return new ResponseEntity<>(reportsService.mostSelledProducts(), HttpStatus.OK);
        }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
        @GetMapping("/productsWithMostIncome")
        public ResponseEntity<ArrayList<ProductsWithMostIncomeDTO>> productsWithMostIncome(){
           return new ResponseEntity<>(reportsService.productsWithMostIncome(),HttpStatus.OK);
        }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
        @GetMapping("/mostSalledByBranch/{id}")
        public ResponseEntity<ArrayList<MostSelledByBranchDTO>> mostSalledByBranch(@PathVariable int id){
            return new ResponseEntity<>(reportsService.mostSalledByBranch(id),HttpStatus.OK);
        }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
        @GetMapping("/mostIncomeByBranch/{id}")
        public ResponseEntity<ArrayList<MostIncomeWithBranchDTO>> mostIncomeByBranch(@PathVariable int id){
           return new ResponseEntity<>(reportsService.mostIncomebySucursal(id),HttpStatus.OK);
        }

        /*All About CLIENT reports*/

    @CrossOrigin(origins = "http://127.0.0.1:5500")
        @GetMapping("/clientWithMostIncome")
        public ResponseEntity<ArrayList<ClientWithMoreIncomeDTO>> clientWithMostIncome(){
           return new ResponseEntity<>(reportsService.clientWithMostIncome(),HttpStatus.OK);
        }

        /*All About BRANCH reports*/

    @CrossOrigin(origins = "http://127.0.0.1:5500")
        @GetMapping("/branchWithMostSales")
        public ResponseEntity<ArrayList<BranchWithMostSalesDTO>> branchWithMostSales(){
          return new ResponseEntity<>(reportsService.branchWithMostSales(),HttpStatus.OK);
        }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
        @GetMapping("/branchWithMostIncome")
        public ResponseEntity<ArrayList<BranchWithMostIncomeDTO>> branchWithMostIncome(){
           return new ResponseEntity<>(reportsService.branchWithMostIncome(),HttpStatus.OK);
        }

        /*All About EMPLOYEE reports*/

    @CrossOrigin(origins = "http://127.0.0.1:5500")
        @GetMapping("/employeeWithMostSales")
        public ResponseEntity<ArrayList<EmployeeWithMostSalesDTO>> employeeWithMostSales(){
           return new ResponseEntity<>(reportsService.employeeWithMostSales(),HttpStatus.OK);
        }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
        @GetMapping("/employeeWithMostIncome")
        public ResponseEntity<ArrayList<EmployeeWithMostIncomeDTO>> employeeWithMostIncome(){
           return new ResponseEntity<>(reportsService.employeeWithMostIncome(),HttpStatus.OK);
        }



}