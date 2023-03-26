package com.example.OnlineShop.dto.product;

import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.model.Inventory;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Getter
@Setter
public class ProductRequest {
    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    private String titleProduct;

    @NotNull(message = "Price cannot be null")
    private Double priceProduct;

    private String descriptionProduct;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    public ProductRequest(String titleProduct, Double priceProduct, String descriptionProduct, Category category, Inventory inventory) {
        this.titleProduct = titleProduct;
        this.priceProduct = priceProduct;
        this.descriptionProduct = descriptionProduct;
        this.category = category;
        this.inventory = inventory;
    }

    public ProductRequest() {
    }
}
