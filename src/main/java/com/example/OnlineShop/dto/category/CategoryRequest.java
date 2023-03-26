package com.example.OnlineShop.dto.category;

import com.example.OnlineShop.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class CategoryRequest {

    @NotNull(message = "The name cannot be null")
    @NotEmpty(message = "The name cannot be empty")
    private String nameCategory;

    public CategoryRequest(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
