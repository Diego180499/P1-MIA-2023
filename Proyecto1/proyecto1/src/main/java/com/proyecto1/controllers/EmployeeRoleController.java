package com.proyecto1.controllers;

import com.proyecto1.dto.roleEmployeeDTO.response.RoleEmployeeDTO;
import com.proyecto1.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/role")
public class EmployeeRoleController {

    @Autowired
    private EmployeeRoleService employeeRoleService;


    @GetMapping("/all")
    public ResponseEntity<ArrayList<RoleEmployeeDTO>> getAll(){
        return new ResponseEntity<>(employeeRoleService.getAll(),HttpStatus.OK);
    }
}
