package com.proyecto1.service;


import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.clientDTO.response.ClientDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;
import com.proyecto1.dto.saleDTO.request.NewSaleDTO;
import com.proyecto1.dto.saleDTO.response.SaleCreatedDTO;
import com.proyecto1.dto.saleDTO.response.SaleDTO;
import com.proyecto1.exception.MarketException;
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


    public SaleCreatedDTO makeSale(NewSaleDTO newSale) throws MarketException {

        validateData(newSale);

        Date saleDate = ProjectUtils.StringToDate(newSale.getSaleDate(),"yyyy-MM-dd");
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
        SaleCreatedDTO saleCreatedDTO = new SaleCreatedDTO();
        saleCreatedDTO.setSale(saleDTO);
        saleCreatedDTO.setMessage("La venta No. "+saleDTO.getSaleId()+" ha sido creada");
        saleCreatedDTO.setStatus(200);
        return saleCreatedDTO;
    }


    public SaleDTO getById(Integer id) throws MarketException {
        if(!saleCrud.existsById(id)){
            throw new MarketException("La venta no existe",404);
        }

        Sale sale = saleCrud.findById(id).get();
        EmployeeDTO employeeDTO = employeeService.getByDpi(sale.getEmployee());
        BranchDTO branchDTO = branchService.getById(sale.getBranch());
        ClientDTO clientDTO = clientService.getClientById(sale.getClient());

        SaleDTO saleDTO = SaleUtils.SaleToSaleDTO(sale,branchDTO,clientDTO,employeeDTO);
        return saleDTO;
    }

    public ArrayList<SaleDTO> getAll() throws MarketException {
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

    public Boolean exist(int id){
        return saleCrud.existsById(id);
    }

    //Private methods ***
    private void validateData(NewSaleDTO newSale) throws MarketException {

        if(!clientService.exist(newSale.getClient())){
            throw new MarketException("El cliente con el nit '"+newSale.getClient()+"' no existe",404);
        }

        if(!branchService.exist(newSale.getBranch())){
            throw new MarketException("La sucursal no existe",404);
        }

        if(!employeeService.exist(newSale.getEmployee())){
            throw new MarketException("El empleado con el dpi '"+newSale.getEmployee()+"' no existe",404);
        }

    }


    public Integer getLastSaleCustomer(String nit){
        try {
            if(nit.equals("c/f")){
                return 0;
            }
            ArrayList<String> total = saleCrud.getLastSale(nit);
            String data [] = total.get(1).split(",");
            int valorTotal = Integer.parseInt(data[0]);
            return valorTotal;
        }catch (IndexOutOfBoundsException ex){
            return 0;
        }
    }
}
