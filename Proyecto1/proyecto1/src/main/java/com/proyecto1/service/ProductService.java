package com.proyecto1.service;


import com.proyecto1.dto.categoryDTO.response.ProductCategoryDTO;
import com.proyecto1.dto.productDTO.request.NewProductDTO;
import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.repository.crud.ProductCategoryCrud;
import com.proyecto1.repository.crud.ProductCrud;
import com.proyecto1.repository.entity.Product;
import com.proyecto1.repository.entity.ProductCategory;
import com.proyecto1.utils.ProductUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    @Autowired
    private ProductCrud productCrud;

    @Autowired
    private ProductCategoryService productCategoryService;


    public ProductDTO addProduct(NewProductDTO newProduct){
        Product product = new Product();
        product.setName(newProduct.getName());
        product.setCategory(newProduct.getCategory());
        product.setPrice(newProduct.getPrice());


        product = productCrud.save(product);

        ProductCategoryDTO productCategoryDTO = productCategoryService.getById(product.getCategory());
        ProductDTO productDTO = new ProductDTO();
        productDTO.setPorductId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setCategory(productCategoryDTO);
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }


    public ArrayList<ProductDTO> getAll(){
        ArrayList<Product> products = (ArrayList) productCrud.findAll();

        ArrayList<ProductDTO> productsDTO = new ArrayList<>();

        for(Product product : products){

            ProductCategoryDTO productCategoryDTO = productCategoryService.getById(product.getCategory());
            ProductDTO productDTO = ProductUtils.ProductToProductDTO(product, productCategoryDTO);

            productsDTO.add(productDTO);
        }
        return productsDTO;
    }


    public ProductDTO getById(int id){

        Product product = productCrud.findById(id).get();
        ProductCategoryDTO productCategoryDTO = productCategoryService.getById(product.getCategory());
        ProductDTO productDTO = ProductUtils.ProductToProductDTO(product, productCategoryDTO);

        return productDTO;
    }


    public ProductDTO updateProduct(NewProductDTO newProduct , int id){
        Product product = productCrud.findById(id).get();
        product.setName(newProduct.getName());
        product.setCategory(newProduct.getCategory());
        product.setPrice(newProduct.getPrice());

        product = productCrud.save(product);

        ProductCategoryDTO productCategoryDTO = productCategoryService.getById(product.getCategory());
        ProductDTO productDTO = ProductUtils.ProductToProductDTO(product, productCategoryDTO);
        return productDTO;
    }




}