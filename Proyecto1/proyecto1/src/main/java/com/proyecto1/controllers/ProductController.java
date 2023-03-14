package com.proyecto1.controllers;

import com.proyecto1.dto.productDTO.request.NewProductDTO;
import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody NewProductDTO newProduct){
        return new ResponseEntity<>(productService.addProduct(newProduct), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable int id){
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/modify/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody NewProductDTO newProduct, @PathVariable int id){
        return new ResponseEntity<>(productService.updateProduct(newProduct,id),HttpStatus.CREATED);
    }

}