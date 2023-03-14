package com.proyecto1.repository.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer saleId;

    @Column(name = "empleado")
    private String employee;

    @Column(name = "cliente")
    private String client;

    @Column(name = "fecha_venta")
    private LocalDateTime saleDate;

    @Column(name = "sucursal")
    private Integer branch;

    private  Integer total;

    /*Getters and Setters*/

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
        this.saleDate = saleDate;
    }

    public Integer getBranch() {
        return branch;
    }

    public void setBranch(Integer branch) {
        this.branch = branch;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
