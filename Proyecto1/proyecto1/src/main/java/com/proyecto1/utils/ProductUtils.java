package com.proyecto1.utils;

import com.proyecto1.dto.categoryDTO.response.ProductCategoryDTO;
import com.proyecto1.dto.productDTO.response.ProductDTO;
import com.proyecto1.repository.entity.Product;

public class ProductUtils {


    public static ProductDTO ProductToProductDTO(Product product, ProductCategoryDTO productCategoryDTO){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setCategory(productCategoryDTO);
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }


}
