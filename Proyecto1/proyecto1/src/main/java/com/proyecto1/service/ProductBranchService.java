package com.proyecto1.service;

import com.proyecto1.dto.branchDTO.response.BranchDTO;
import com.proyecto1.dto.productBranchDTO.request.NewProductBranchDTO;
import com.proyecto1.dto.productBranchDTO.response.ProductBranchDTO;
import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.exception.MarketException;
import com.proyecto1.repository.crud.ProductBranchCrud;
import com.proyecto1.repository.entity.ProductBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.error.Mark;

@Service
public class ProductBranchService {

    @Autowired
    ProductBranchCrud productBranchCrud;

    @Autowired
    ProductService productService;

    @Autowired
    BranchService branchService;

    public void addProductBranch(NewProductBranchDTO newProductBranch) throws MarketException {
        //validamos que la sucursal y producto existan
        validateData(newProductBranch);

        String productBranchId = newProductBranch.getProduct()+"-"+newProductBranch.getBranch();
        ProductBranch productBranch;

        if(!productBranchCrud.existsById(productBranchId)){
            productBranch = createNewProductBranch(productBranchId, newProductBranch);
        }else{
            productBranch = productBranchCrud.findById(productBranchId).get();
            Integer actualStock = this.getStock(productBranchId);
            productBranch.setStockAmount(actualStock+newProductBranch.getStockAmount());
        }

        branchService.incrementStock(productBranch.getBranch(),newProductBranch.getStockAmount());
        productBranchCrud.save(productBranch);
    }


    public ProductBranchDTO getProductBranch(String id) throws MarketException {
        if(!productBranchCrud.existsById(id)){
            throw new MarketException("Eñ producto no existe en la sucursal",404);
        }
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


    //Private methods******
    private ProductBranch createNewProductBranch(String id, NewProductBranchDTO newProductBranch){
        ProductBranch productBranch = new ProductBranch();
        productBranch.setProductBranchId(id);
        productBranch.setProduct(newProductBranch.getProduct());
        productBranch.setBranch(newProductBranch.getBranch());
        productBranch.setStockAmount(newProductBranch.getStockAmount());
        return productBranch;
    }

    private void validateData(NewProductBranchDTO newProductBranch) throws MarketException {
        if(!productService.exist(newProductBranch.getProduct())){
            throw new MarketException("El producto no existe",404);
        }

        if(!branchService.exist(newProductBranch.getBranch())){
            throw new MarketException("La sucursal no existe",404);
        }
    }


    public Boolean exist(String id){
        return productBranchCrud.existsById(id);
    }

    public Boolean isAvailable(String productBranchdId, int amount) throws MarketException {
        ProductBranchDTO productBranch = getProductBranch(productBranchdId);
        if(productBranch.getStockAmount()< amount){
            return false;
        }
        return true;
    }

}
