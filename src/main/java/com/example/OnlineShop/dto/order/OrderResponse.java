package com.example.OnlineShop.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Getter
@Setter
public class OrderResponse {
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOrder;

    @Min(value = 5, message = "Min quantity should be at least 5")
    private Double totalPriceOrder;

    public OrderResponse(Date dateOrder, Double totalPriceOrder) {
        this.dateOrder = dateOrder;
        this.totalPriceOrder = totalPriceOrder;
    }

    public OrderResponse() {
    }
}
