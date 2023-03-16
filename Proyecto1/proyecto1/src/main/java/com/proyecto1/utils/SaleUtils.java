package com.proyecto1.utils;

import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.clientDTO.response.ClientDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;
import com.proyecto1.dto.saleDTO.response.SaleDTO;
import com.proyecto1.repository.entity.Sale;
import com.proyecto1.service.ClientService;

public class SaleUtils {

    public static SaleDTO SaleToSaleDTO(Sale sale, BranchDTO branchDTO, ClientDTO clientDTO, EmployeeDTO employeeDTO){
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setSaleId(sale.getSaleId());
        saleDTO.setEmployee(employeeDTO);
        saleDTO.setClient(clientDTO);
        saleDTO.setSaleDate(sale.getSaleDate());
        saleDTO.setBranch(branchDTO);
        saleDTO.setTotal(sale.getTotal());

        return saleDTO;
    }


}
