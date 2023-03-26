package com.example.OnlineShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    private String titleProduct;

    @NotNull(message = "Price cannot be null")
    private Double priceProduct;

    @NotNull(message = "The description cannot be null")
    private String descriptionProduct;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Order> orders;



    public Product(int idProduct, String titleProduct, Double priceProduct, String descriptionProduct, Category category, List<Order> orders, Inventory inventory) {
        this.idProduct = idProduct;
        this.titleProduct = titleProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.category = category;
        this.orders = orders;
        this.inventory = inventory;
    }

    public Product(){}
    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getTitleProduct() {
        return titleProduct;
    }

    public void setTitleProduct(String titleProduct) {
        this.titleProduct = titleProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
