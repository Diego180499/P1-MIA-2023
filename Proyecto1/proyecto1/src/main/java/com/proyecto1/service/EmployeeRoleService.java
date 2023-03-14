package com.proyecto1.service;

import com.proyecto1.dto.roleEmployeeDTO.response.RoleEmployeeDTO;
import com.proyecto1.repository.crud.EmployeeRoleCrud;
import com.proyecto1.repository.entity.EmployeeRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeRoleService {

    @Autowired
    private EmployeeRoleCrud employeeRoleCrud;



    public ArrayList<RoleEmployeeDTO> getAll(){
        ArrayList<RoleEmployeeDTO> roles = (ArrayList) employeeRoleCrud.findAll();
        return roles;
    }

    public RoleEmployeeDTO getById(int id){
        EmployeeRole employeeRole = employeeRoleCrud.findById(id).get();

        RoleEmployeeDTO roleEmployeeDTO = new RoleEmployeeDTO();
        roleEmployeeDTO.setRoleId(employeeRole.getRoleId());
        roleEmployeeDTO.setJobPosition(employeeRole.getJobPosition());

        return roleEmployeeDTO;
    }




}
