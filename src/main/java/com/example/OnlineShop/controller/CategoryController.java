package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.service.CategoryService;
import com.example.OnlineShop.service.CategoryServiceInt;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceInt categoryServiceInt;

    public CategoryController(CategoryService categoryService, CategoryServiceInt categoryServiceInt) {
        this.categoryServiceInt = categoryServiceInt;
    }


    @PutMapping
    public CategoryResponse editCategory(@RequestBody CategoryRequest category, @RequestParam @NotNull Integer idCategory){
        return  categoryServiceInt.editCategory(category, idCategory);
    }

    @DeleteMapping
    public String deleteCategory(@RequestParam Integer idCategory){
        return categoryServiceInt.deleteCategory(idCategory);
    }

    @GetMapping
    public List<Category> getAllCategory(){
        return categoryServiceInt.getAllCategory();
    }


}
