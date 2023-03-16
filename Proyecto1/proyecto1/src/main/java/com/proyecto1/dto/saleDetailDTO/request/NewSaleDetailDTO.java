package com.proyecto1.dto.saleDetailDTO.request;

public class NewSaleDetailDTO {

    private Integer sale;
    private Integer product;
    private Integer amount;

    /* Getters and Setters */

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
