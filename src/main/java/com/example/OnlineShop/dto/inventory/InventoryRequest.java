package com.example.OnlineShop.dto.inventory;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@Getter
@Setter
public class InventoryRequest {

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1,message = "It has to be ore then 1" )
    private Integer quantityProduct;

    @NotNull(message = "Sales cannot be null")
    @Min(value = 1,message = "It has to be more then 1" )
    private Integer salesProduct;

    public InventoryRequest(Integer quantityProduct, Integer salesProduct) {
        this.quantityProduct = quantityProduct;
        this.salesProduct = salesProduct;
    }

    public InventoryRequest() {
    }
}
