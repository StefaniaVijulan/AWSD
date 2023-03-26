package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.repository.CategoryRepository;
import com.example.OnlineShop.service.CategoryService;
import com.example.OnlineShop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public CategoryResponse addCategory(@RequestBody CategoryRequest category) throws Exception {
        return categoryService.addCategory(category);
    }
    @PutMapping("/editCategory")
    public CategoryResponse editCategory(@RequestBody CategoryRequest category, @RequestParam @NotNull Integer idCategory){
        return  categoryService.editCategory(category, idCategory);
    }

    @DeleteMapping("/deleteCategory")
    public String deleteCategory(@RequestParam Integer idCategory){
        return categoryService.deleteCategory(idCategory);
    }

    @GetMapping("/getAllCategory")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/getCategoryByName")
    public List<Category> getCategoryByName(@RequestParam String nameCategory){
        return categoryService.getAllCategoryWithASpecificName(nameCategory);
    }

}
