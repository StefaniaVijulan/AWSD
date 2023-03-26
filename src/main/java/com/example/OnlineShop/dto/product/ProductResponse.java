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

@RequiredArgsConstructor
@Data
@Getter
@Setter
public class ProductResponse {
    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    private String titleProduct;

    @NotNull(message = "Price cannot be null")
    private Double priceProduct;

    @NotNull(message = "Description cannot be null")
    private String descriptionProduct;


}
