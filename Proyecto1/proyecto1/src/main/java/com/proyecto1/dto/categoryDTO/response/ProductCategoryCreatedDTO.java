package com.proyecto1.dto.categoryDTO.response;

public class ProductCategoryCreatedDTO {

    private String message;
    private ProductCategoryDTO productCategoryDTO;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProductCategoryDTO getProductCategoryDTO() {
        return productCategoryDTO;
    }

    public void setProductCategoryDTO(ProductCategoryDTO productCategoryDTO) {
        this.productCategoryDTO = productCategoryDTO;
    }
}
