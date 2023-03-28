package com.proyecto1.controllers;


import com.proyecto1.dto.saleDetailDTO.request.NewSaleDetailDTO;
import com.proyecto1.dto.saleDetailDTO.response.SaleDetailCreatedDTO;
import com.proyecto1.dto.saleDetailDTO.response.SaleDetailDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.service.SaleDetailService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/saleDetail")
public class SaleDetailController {

    @Autowired
    SaleDetailService saleDetailService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/add/{branchId}")
    public ResponseEntity<SaleDetailCreatedDTO> addDetail(@RequestBody NewSaleDetailDTO newSaleDetail, @PathVariable int branchId){
        try {
            return new ResponseEntity<>(saleDetailService.addSaleDetail(newSaleDetail,branchId),HttpStatus.CREATED);
        } catch (MarketException e) {
            return new ResponseEntity(e.getMarketExceptionDTO(),HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/all")
    public ResponseEntity<ArrayList<SaleDetailDTO>> getAll(){
        try {
            return new ResponseEntity<>(saleDetailService.getAll(),HttpStatus.OK);
        } catch (MarketException e) {
            throw new RuntimeException(e);
        }
    }





}
