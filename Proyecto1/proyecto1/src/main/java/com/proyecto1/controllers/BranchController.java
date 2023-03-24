package com.proyecto1.controllers;


import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/branch")
public class BranchController {


    @Autowired
    BranchService branchService;



    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/all")
    public ResponseEntity<ArrayList<BranchDTO>> getAll(){
        return new ResponseEntity<>(branchService.getAll(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/find/{id}")
    public ResponseEntity getById(@PathVariable int id){
        try {
            return new ResponseEntity<>(branchService.getById(id),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.NOT_FOUND);
            //throw new RuntimeException(e);
        }
    }

}
