package com.proyecto1.dto.employeeDTO.response;

public class EmployeeCreatedDTO {

    private EmployeeDTO employee;
    private Integer status;

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
