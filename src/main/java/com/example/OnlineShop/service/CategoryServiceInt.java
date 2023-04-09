package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.model.Category;
import java.util.List;

public interface CategoryServiceInt {

    public CategoryResponse addCategory(CategoryRequest category);
    public CategoryResponse editCategory(CategoryRequest category, Integer idCategory);
    public String deleteCategory(Integer idCategory);
    public List<Category> getAllCategory();
    public List<Category> getAllCategoryWithASpecificName(String nameCategory);
}
