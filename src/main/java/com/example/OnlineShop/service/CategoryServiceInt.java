package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryServiceInt {

    public CategoryResponse addCategory(CategoryRequest category);
    public CategoryResponse editCategory(CategoryRequest category, Integer idCategory);
    public String deleteCategory(Integer idCategory);
    public List<Category> getAllCategory();
    Page<Category> findPaginated(Pageable pageable);

}
