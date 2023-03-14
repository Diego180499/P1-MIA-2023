package com.proyecto1.dto.productDTO.request;

public class NewProductDTO {

    private String name;
    private Integer category;
    private Integer price;


    public NewProductDTO(String name, Integer category, Integer price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }


    /*Getters and Setters*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
