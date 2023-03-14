package com.proyecto1.dto.employeeDTO.response;

import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.roleEmployeeDTO.response.RoleEmployeeDTO;

import java.util.Date;

public class EmployeeDTO {

    private String dpi;
    private String name;
    private String lastName;
    private Date birhtDate;
    private Integer phone;
    private BranchDTO branchDTO;
    private Integer salary;
    private RoleEmployeeDTO roleEmployeeDTO;


    /* Getters and Setters */

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirhtDate() {
        return birhtDate;
    }

    public void setBirhtDate(Date birhtDate) {
        this.birhtDate = birhtDate;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public BranchDTO getBranchDTO() {
        return branchDTO;
    }

    public void setBranchDTO(BranchDTO branchDTO) {
        this.branchDTO = branchDTO;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public RoleEmployeeDTO getRoleEmployeeDTO() {
        return roleEmployeeDTO;
    }

    public void setRoleEmployeeDTO(RoleEmployeeDTO roleEmployeeDTO) {
        this.roleEmployeeDTO = roleEmployeeDTO;
    }
}
