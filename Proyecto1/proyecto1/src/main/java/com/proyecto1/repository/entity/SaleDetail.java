package com.proyecto1.repository.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class SaleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer detailId;


    @Column(name = "venta")
    private  Integer sale;

    @Column(name = "producto")
    private Integer product;

    @Column(name = "cantidad")
    private Integer amount;

    @Column(name = "total_detalle")
    private Integer total;

    /*Getters and Setters*/

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
