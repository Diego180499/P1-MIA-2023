package com.proyecto1.repository.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto_sucursal")
public class ProductBranch {


    @Id
    @Column(name = "id_producto_sucursal")
    private  String productBranchId;


    @Column(name = "producto")
    private Integer product;


    @Column(name = "sucursal")
    private Integer branch;


    @Column(name = "cantidad_stock")
    private Integer stockAmount;


    /*Getters and Setters*/

    public String getProductBranchId() {
        return productBranchId;
    }

    public void setProductBranchId(String productBranchId) {
        this.productBranchId = productBranchId;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getBranch() {
        return branch;
    }

    public void setBranch(Integer branch) {
        this.branch = branch;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }
}
