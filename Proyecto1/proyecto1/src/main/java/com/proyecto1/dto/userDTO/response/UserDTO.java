package com.proyecto1.dto.userDTO.response;

import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;

public class UserDTO {

    private String user;
    private String password;

    private EmployeeDTO employee;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
