package com.proyecto1.controllers;


import com.proyecto1.dto.saleDetailDTO.request.NewSaleDetailDTO;
import com.proyecto1.dto.saleDetailDTO.response.SaleDetailDTO;
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

    @PostMapping("/add/{branchId}")
    public ResponseEntity<SaleDetailDTO> addDetail(@RequestBody NewSaleDetailDTO newSaleDetail, @PathVariable int branchId){
        return new ResponseEntity<>(saleDetailService.addSaleDetail(newSaleDetail,branchId),HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<SaleDetailDTO>> getAll(){
        return new ResponseEntity<>(saleDetailService.getAll(),HttpStatus.OK);
    }





}
