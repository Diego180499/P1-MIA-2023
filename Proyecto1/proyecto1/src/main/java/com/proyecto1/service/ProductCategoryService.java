package com.proyecto1.service;


import com.proyecto1.dto.categoryDTO.request.NewCategoryDTO;
import com.proyecto1.dto.categoryDTO.response.ProductCategoryCreatedDTO;
import com.proyecto1.dto.categoryDTO.response.ProductCategoryDTO;
import com.proyecto1.repository.crud.ProductCategoryCrud;
import com.proyecto1.repository.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryCrud productCategoryCrud;

    public ProductCategoryCreatedDTO addProductCategory(NewCategoryDTO category){

        ProductCategory productCategory = new ProductCategory();
        productCategory.setDescription(category.getDescription());

        productCategory = productCategoryCrud.save(productCategory);
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setCategoryId(productCategory.getCategoryId());
        productCategoryDTO.setDescription(productCategory.getDescription());

        ProductCategoryCreatedDTO productCategoryCreatedDTO = new ProductCategoryCreatedDTO();
        productCategoryCreatedDTO.setMessage("Product Category Created");
        productCategoryCreatedDTO.setProductCategoryDTO(productCategoryDTO);

        return productCategoryCreatedDTO;
    }


    public ArrayList<ProductCategoryDTO> getAllProductCategory(){
        ArrayList<ProductCategoryDTO> categories = new ArrayList<>();

        categories =(ArrayList) productCategoryCrud.findAll();
        return categories;
    }


    public ProductCategoryDTO getById(Integer id){
        ProductCategory productCategory = productCategoryCrud.findById(id).get();

        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setCategoryId(productCategory.getCategoryId());
        productCategoryDTO.setDescription(productCategory.getDescription());


        return productCategoryDTO;
    }

    public Boolean exist(int id){
        return productCategoryCrud.existsById(id);
    }


}
