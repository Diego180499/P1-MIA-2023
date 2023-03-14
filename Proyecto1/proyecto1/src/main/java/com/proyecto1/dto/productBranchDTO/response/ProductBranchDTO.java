package com.proyecto1.dto.productBranchDTO.response;

import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.productDTO.response.ProductDTO;

public class ProductBranchDTO {

    private String productBranchId;
    private ProductDTO product;
    private BranchDTO branch;
    private Integer stockAmount;


    /* Getters and Setters */

    public String getProductBranchId() {
        return productBranchId;
    }

    public void setProductBranchId(String productBranchId) {
        this.productBranchId = productBranchId;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public BranchDTO getBranch() {
        return branch;
    }

    public void setBranch(BranchDTO branch) {
        this.branch = branch;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }
}
