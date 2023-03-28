package com.proyecto1.dto.reportsDTO.productReportDTO;

public class MostSelledProductDTO {

    private String productName;
    private Integer saleAmount;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(Integer saleAmount) {
        this.saleAmount = saleAmount;
    }
}
