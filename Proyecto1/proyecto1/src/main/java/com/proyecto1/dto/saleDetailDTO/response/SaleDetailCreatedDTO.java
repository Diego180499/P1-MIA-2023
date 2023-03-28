package com.proyecto1.dto.saleDetailDTO.response;

public class SaleDetailCreatedDTO {

    private SaleDetailDTO sale;
    private String message;
    private Integer status;

    /* Getters and Setters */

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SaleDetailDTO getSale() {
        return sale;
    }

    public void setSale(SaleDetailDTO sale) {
        this.sale = sale;
    }
}
