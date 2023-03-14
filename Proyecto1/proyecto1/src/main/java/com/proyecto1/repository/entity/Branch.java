package com.proyecto1.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Branch {

    @Id
    @Column(name = "id_sucursal")
    private Integer branchId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "cantidad_productos")
    private Integer productsAmount;


    /*Getters and Setters*/
    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductsAmount() {
        return productsAmount;
    }

    public void setProductsAmount(Integer productsAmount) {
        this.productsAmount = productsAmount;
    }
}
