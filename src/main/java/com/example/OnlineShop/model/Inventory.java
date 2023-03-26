package com.example.OnlineShop.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInventory;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1,message = "It has to be ore then 1" )
    private Integer quantityProduct;

    @NotNull(message = "Sales cannot be null")
    @Min(value = 1,message = "It has to be more then 1" )
    private Integer salesProduct;


    public Inventory() {
    }

    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public Integer getSalesProduct() {
        return salesProduct;
    }

    public void setSalesProduct(Integer salesProduct) {
        this.salesProduct = salesProduct;
    }

}
