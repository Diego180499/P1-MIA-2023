package com.proyecto1.controllers;


import com.proyecto1.dto.employeeDTO.request.NewEmployeeDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;
import com.proyecto1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody NewEmployeeDTO newEmployee){
        employeeService.saveEmployee(newEmployee);
        return "Creado";
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<EmployeeDTO>> getAll(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/find/{dpi}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable String dpi){
        return new ResponseEntity<>(employeeService.getByDpi(dpi),HttpStatus.OK);
    }


    @PostMapping("/modify/{dpi}")
    public ResponseEntity modifyEmployee(@RequestBody NewEmployeeDTO employee, @PathVariable String dpi){
        employeeService.modifyEmployee(employee,dpi);
        return new ResponseEntity(HttpStatus.CREATED);
    }




}
