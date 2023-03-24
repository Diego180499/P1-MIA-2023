package com.proyecto1.dto.userDTO.response;

import com.proyecto1.dto.userDTO.request.NewUserDTO;

public class UserCreatedDTO {

    private NewUserDTO user;
    private Integer status;

    public NewUserDTO getUser() {
        return user;
    }

    public void setUser(NewUserDTO user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
