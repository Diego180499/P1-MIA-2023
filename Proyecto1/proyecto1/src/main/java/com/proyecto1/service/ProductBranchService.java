package com.proyecto1.service;

import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.productBranchDTO.request.NewProductBranchDTO;
import com.proyecto1.dto.productBranchDTO.response.ProductBranchDTO;
import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.repository.crud.ProductBranchCrud;
import com.proyecto1.repository.entity.ProductBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBranchService {

    @Autowired
    ProductBranchCrud productBranchCrud;

    @Autowired
    ProductService productService;

    @Autowired
    BranchService branchService;

    public void addProductBranch(NewProductBranchDTO newProductBranch){
        ProductBranch productBranch = new ProductBranch();
        productBranch.setProductBranchId(newProductBranch.getProduct()+"-"+newProductBranch.getBranch());
        productBranch.setProduct(newProductBranch.getProduct());
        productBranch.setBranch(newProductBranch.getBranch());
        productBranch.setStockAmount(newProductBranch.getStockAmount());

        productBranchCrud.save(productBranch);
    }


    public ProductBranchDTO getProductBranch(String id){
        ProductBranch productBranch = productBranchCrud.findById(id).get();
        ProductDTO productDTO = productService.getById(productBranch.getProduct());
        BranchDTO branchDTO = branchService.getById(productBranch.getBranch());

        ProductBranchDTO productBranchDTO = new ProductBranchDTO();
        productBranchDTO.setProductBranchId(productBranch.getProductBranchId());
        productBranchDTO.setProduct(productDTO);
        productBranchDTO.setBranch(branchDTO);
        productBranchDTO.setStockAmount(productBranch.getStockAmount());

        return productBranchDTO;
    }



}
