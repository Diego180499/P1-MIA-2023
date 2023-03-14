package com.proyecto1.dto.productBranchDTO.request;

public class NewProductBranchDTO {

    private Integer product;
    private Integer branch;
    private Integer stockAmount;

    /* Getters and Setters */

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
