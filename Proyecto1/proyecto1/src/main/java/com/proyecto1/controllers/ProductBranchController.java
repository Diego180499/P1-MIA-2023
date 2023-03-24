package com.proyecto1.controllers;

import com.proyecto1.dto.productBranchDTO.request.NewProductBranchDTO;
import com.proyecto1.dto.productBranchDTO.request.SendProductDTO;
import com.proyecto1.dto.productBranchDTO.response.ProductBranchDTO;
import com.proyecto1.dto.productBranchDTO.response.ProductSendedDTO;
import com.proyecto1.dto.productDTO.request.NewProductDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.service.ProductBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/productBranch")
public class ProductBranchController {

    @Autowired
    ProductBranchService productBranchService;


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/add")
    public ResponseEntity<ProductSendedDTO> addProductBranch(@RequestBody NewProductBranchDTO newProductBranch){
        try {
            return new ResponseEntity<>(productBranchService.addProductBranch(newProductBranch), HttpStatus.CREATED);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/find/{id}")
    public ResponseEntity<ProductBranchDTO> getById(@PathVariable String id){
        try {
            return new ResponseEntity<>(productBranchService.getProductBranch(id),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/find/sucursal/{idSucursal}")
    public ResponseEntity<ArrayList<ProductBranchDTO>> getBySucursal(@PathVariable int idSucursal){
        try {
            return new ResponseEntity<>(productBranchService.getBySucursal(idSucursal),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/sendProduct")
    public ResponseEntity<ProductSendedDTO> sendProduct(@RequestBody SendProductDTO sendProduct){
        try {
            return new ResponseEntity<>(productBranchService.sendProduct(sendProduct),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(), HttpStatus.BAD_REQUEST);
        }
    }



}
