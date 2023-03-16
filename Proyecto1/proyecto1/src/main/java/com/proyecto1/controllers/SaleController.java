package com.proyecto1.controllers;

import com.proyecto1.dto.saleDTO.request.NewSaleDTO;
import com.proyecto1.dto.saleDTO.response.SaleDTO;
import com.proyecto1.exception.MarketException;
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
        try {
            return new ResponseEntity<>(saleService.makeSale(newSale), HttpStatus.CREATED);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable int id){
        try {
            return new ResponseEntity<>(saleService.getById(id),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<SaleDTO>> getAll(){
        try {
            return new ResponseEntity<>(saleService.getAll(),HttpStatus.OK);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.NOT_FOUND);
        }
    }




}
