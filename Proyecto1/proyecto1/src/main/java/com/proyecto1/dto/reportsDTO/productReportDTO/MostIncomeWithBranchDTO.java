package com.proyecto1.dto.reportsDTO.productReportDTO;

public class MostIncomeWithBranchDTO {

    private String branchName;
    private String productName;
    private Integer income;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }
}
