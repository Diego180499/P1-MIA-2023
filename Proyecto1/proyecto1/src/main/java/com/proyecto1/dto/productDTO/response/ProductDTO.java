package com.proyecto1.dto.productDTO.response;

import com.proyecto1.dto.categoryDTO.response.ProductCategoryDTO;

public class ProductDTO {

    private Integer porductId;
    private String name;
    private ProductCategoryDTO category;
    private Integer price;

    public Integer getPorductId() {
        return porductId;
    }

    public void setPorductId(Integer porductId) {
        this.porductId = porductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryDTO category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
