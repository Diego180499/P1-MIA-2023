package com.proyecto1.service;


import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.clientDTO.response.ClientDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;
import com.proyecto1.dto.saleDTO.request.NewSaleDTO;
import com.proyecto1.dto.saleDTO.response.SaleDTO;
import com.proyecto1.repository.crud.SaleCrud;
import com.proyecto1.repository.entity.Employee;
import com.proyecto1.repository.entity.Sale;
import com.proyecto1.utils.ProjectUtils;
import com.proyecto1.utils.SaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class SaleService {
    @Autowired
    SaleCrud saleCrud;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    BranchService branchService;

    @Autowired
    ClientService clientService;


    public SaleDTO makeSale(NewSaleDTO newSale){
        Date saleDate = ProjectUtils.StringToDate(newSale.getSaleDate(),"dd-MM-yyyy");
        Sale sale = new Sale();
        sale.setEmployee(newSale.getEmployee());
        sale.setClient(newSale.getClient());
        sale.setSaleDate(saleDate);
        sale.setBranch(newSale.getBranch());
        sale.setTotal(0);

        sale = saleCrud.save(sale);

        EmployeeDTO employeeDTO = employeeService.getByDpi(sale.getEmployee());
        BranchDTO branchDTO = branchService.getById(sale.getBranch());
        ClientDTO clientDTO = clientService.getClientById(sale.getClient());

        SaleDTO saleDTO = SaleUtils.SaleToSaleDTO(sale,branchDTO,clientDTO,employeeDTO);
        return saleDTO;
    }


    public SaleDTO getById(Integer id){
        Sale sale = saleCrud.findById(id).get();
        EmployeeDTO employeeDTO = employeeService.getByDpi(sale.getEmployee());
        BranchDTO branchDTO = branchService.getById(sale.getBranch());
        ClientDTO clientDTO = clientService.getClientById(sale.getClient());

        SaleDTO saleDTO = SaleUtils.SaleToSaleDTO(sale,branchDTO,clientDTO,employeeDTO);
        return saleDTO;

    }

    public ArrayList<SaleDTO> getAll(){
        ArrayList<Sale> sales = (ArrayList) saleCrud.findAll();
        ArrayList<SaleDTO> salesDTO = new ArrayList<>();
        for(Sale sale: sales){
            EmployeeDTO employeeDTO = employeeService.getByDpi(sale.getEmployee());
            BranchDTO branchDTO = branchService.getById(sale.getBranch());
            ClientDTO clientDTO = clientService.getClientById(sale.getClient());

            SaleDTO saleDTO = SaleUtils.SaleToSaleDTO(sale,branchDTO,clientDTO,employeeDTO);
            salesDTO.add(saleDTO);
        }

        return salesDTO;
    }

    public void modifyTotal(int id, int total){
        Sale sale = saleCrud.findById(id).get();
        sale.setTotal(total);

        saleCrud.save(sale);
    }

    public Integer getSaleTotal(int id){
            Integer total = saleCrud.getSaleTotal(id);
            return total;
    }
}
