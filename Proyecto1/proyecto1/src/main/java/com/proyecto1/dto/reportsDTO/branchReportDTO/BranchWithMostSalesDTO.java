package com.proyecto1.dto.reportsDTO.branchReportDTO;

public class BranchWithMostSalesDTO {

    private String branchName;
    private Integer salesAmount;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Integer getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(Integer salesAmount) {
        this.salesAmount = salesAmount;
    }
}
