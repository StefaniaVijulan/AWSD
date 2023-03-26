package com.example.OnlineShop.dto.category;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class CategoryResponse {
    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String nameCategory;

    public CategoryResponse(String nameCategory) {
        this.nameCategory = nameCategory;
    }
    public CategoryResponse(){}
}
