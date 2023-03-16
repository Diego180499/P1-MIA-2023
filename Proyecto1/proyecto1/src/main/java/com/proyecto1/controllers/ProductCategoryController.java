package com.proyecto1.controllers;


import com.proyecto1.dto.categoryDTO.request.NewCategoryDTO;
import com.proyecto1.dto.categoryDTO.response.ProductCategoryCreatedDTO;
import com.proyecto1.dto.categoryDTO.response.ProductCategoryDTO;
import com.proyecto1.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @PostMapping("/add")
    public ResponseEntity<ProductCategoryCreatedDTO> saveProductCategory(@RequestBody NewCategoryDTO category){
        return new ResponseEntity<>(productCategoryService.addProductCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<ProductCategoryDTO>> getAll(){
        return new ResponseEntity<>(productCategoryService.getAllProductCategory(), HttpStatus.OK);
    }
}