package com.proyecto1.controllers;


import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/branch")
public class BranchController {


    @Autowired
    BranchService branchService;



    @GetMapping("/all")
    public ResponseEntity<ArrayList<BranchDTO>> getAll(){
        return new ResponseEntity<>(branchService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<BranchDTO> getById(@PathVariable int id){
        return new ResponseEntity<>(branchService.getById(id),HttpStatus.OK);
    }

}
