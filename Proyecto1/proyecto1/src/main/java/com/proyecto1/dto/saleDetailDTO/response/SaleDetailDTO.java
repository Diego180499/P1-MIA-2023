package com.proyecto1.dto.saleDetailDTO.response;

import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.dto.saleDTO.response.SaleDTO;

public class SaleDetailDTO {

    private Integer detailId;
    private SaleDTO sale;
    private ProductDTO product;
    private Integer amount;
    private Integer total;

    /* Getters and Setters*/

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public SaleDTO getSale() {
        return sale;
    }

    public void setSale(SaleDTO sale) {
        this.sale = sale;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
