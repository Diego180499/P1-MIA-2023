package com.proyecto1.dto.saleDTO.response;

import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.clientDTO.response.ClientDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;


import java.util.Date;

public class SaleDTO {

    private Integer saleId;
    private EmployeeDTO employee;
    private ClientDTO client;
    private Date saleDate;
    private BranchDTO branch;
    private  Integer total;

    /* Getters and Setters */

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public BranchDTO getBranch() {
        return branch;
    }

    public void setBranch(BranchDTO branch) {
        this.branch = branch;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
