package com.proyecto1.dto.productDTO.response;

public class ProductCreatedDTO {

    private ProductDTO product;
    private Integer status;

    /* GETTERS AND SETTERS */

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
