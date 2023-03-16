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
        String productBranchId = newProductBranch.getProduct()+"-"+newProductBranch.getBranch();
        ProductBranch productBranch;

        if(!productBranchCrud.existsById(productBranchId)){
            productBranch = new ProductBranch();
            productBranch.setProductBranchId(productBranchId);
            productBranch.setProduct(newProductBranch.getProduct());
            productBranch.setBranch(newProductBranch.getBranch());
            productBranch.setStockAmount(newProductBranch.getStockAmount());
        }else{
            productBranch = productBranchCrud.findById(productBranchId).get();
            Integer actualStock = this.getStock(productBranchId);
            productBranch.setStockAmount(actualStock+newProductBranch.getStockAmount());
        }

        branchService.incrementStock(productBranch.getBranch(),newProductBranch.getStockAmount());
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

    public Integer getStock(String id){
        return  productBranchCrud.getStock(id);
    }

    public void reduceStock(String id, int amount){
        int actualStock = getStock(id);
        ProductBranch productBranch = productBranchCrud.findById(id).get();
        productBranch.setStockAmount(actualStock-amount);
        productBranchCrud.save(productBranch);
    }

}
