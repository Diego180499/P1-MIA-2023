package com.proyecto1.controllers;

import com.proyecto1.dto.saleDTO.request.NewSaleDTO;
import com.proyecto1.dto.saleDTO.response.SaleDTO;
import com.proyecto1.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    SaleService saleService;

    @PostMapping("/add")
    public ResponseEntity<SaleDTO> makeSale(@RequestBody NewSaleDTO newSale){
        return new ResponseEntity<>(saleService.makeSale(newSale), HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable int id){
        return new ResponseEntity<>(saleService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<SaleDTO>> getAll(){
        return new ResponseEntity<>(saleService.getAll(),HttpStatus.OK);
    }


}
