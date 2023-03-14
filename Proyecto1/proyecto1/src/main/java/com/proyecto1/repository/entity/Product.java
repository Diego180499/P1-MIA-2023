package com.proyecto1.repository.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Product {

    @Id
    @Column(name = "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "categoria")
    private Integer category;

    @Column(name = "precio_venta")
    private Integer price;

    /*GETTERS AND SETTERS*/

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

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
