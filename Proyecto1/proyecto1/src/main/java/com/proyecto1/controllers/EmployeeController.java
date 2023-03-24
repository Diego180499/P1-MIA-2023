package com.proyecto1.controllers;


import com.proyecto1.dto.employeeDTO.request.NewEmployeeDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeCreatedDTO;
import com.proyecto1.dto.employeeDTO.response.EmployeeDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.service.EmployeeService;
import org.apache.coyote.Response;
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

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/add")
    public ResponseEntity<EmployeeCreatedDTO> saveEmployee(@RequestBody NewEmployeeDTO newEmployee){
        try {
            return new ResponseEntity(employeeService.saveEmployee(newEmployee),HttpStatus.CREATED);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(), HttpStatus.BAD_REQUEST);
        }
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/all")
    public ResponseEntity<ArrayList<EmployeeDTO>> getAll(){
        try {
            return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(), HttpStatus.NOT_FOUND);
        }
    }



    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/find/{dpi}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable String dpi){
        try {
            return new ResponseEntity<>(employeeService.getByDpi(dpi),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(), HttpStatus.NOT_FOUND);
        }
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/modify/{dpi}")
    public ResponseEntity modifyEmployee(@RequestBody NewEmployeeDTO employee, @PathVariable String dpi){
        try {
            return new ResponseEntity(employeeService.modifyEmployee(employee,dpi),HttpStatus.CREATED);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(), HttpStatus.NOT_FOUND);
        }

    }




}
