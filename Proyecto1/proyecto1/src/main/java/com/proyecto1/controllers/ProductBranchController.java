package com.proyecto1.controllers;

import com.proyecto1.dto.productBranchDTO.request.NewProductBranchDTO;
import com.proyecto1.dto.productBranchDTO.response.ProductBranchDTO;
import com.proyecto1.dto.productDTO.request.NewProductDTO;
import com.proyecto1.service.ProductBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productBranch")
public class ProductBranchController {

    @Autowired
    ProductBranchService productBranchService;


    @PostMapping("/add")
    public ResponseEntity addProductBranch(@RequestBody NewProductBranchDTO newProductBranch){
        productBranchService.addProductBranch(newProductBranch);
        return new ResponseEntity( HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductBranchDTO> getById(@PathVariable String id){
        return new ResponseEntity<>(productBranchService.getProductBranch(id),HttpStatus.OK);
    }



}
