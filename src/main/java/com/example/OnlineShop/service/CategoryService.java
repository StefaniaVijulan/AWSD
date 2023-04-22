package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements CategoryServiceInt{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryResponse addCategory(CategoryRequest category){
        Category category1 = categoryRepository.findByNameCategory(category.getNameCategory());
        if(category1 != null){
            throw new Custom("This category name exist");
        }
        Category category2 = new Category();
        category2.setNameCategory(category.getNameCategory());
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setNameCategory(category.getNameCategory());
        categoryRepository.save(category2);
        return categoryResponse;
    }
    @Override
    public CategoryResponse editCategory(CategoryRequest category, Integer idCategory){
        System.out.println("id is" + idCategory);
        Category category1 = categoryRepository.findById(idCategory).orElseThrow(
                () -> new RuntimeException("Category with this id is not found"));
        category1.setNameCategory(category.getNameCategory());
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setNameCategory(category.getNameCategory());
        categoryRepository.save(category1);
        return categoryResponse;
    }
    @Override
    public String deleteCategory(Integer idCategory){
        Category category1 = categoryRepository.findById(idCategory).orElseThrow(
                () -> new RuntimeException("Order with this id is not found"));
        categoryRepository.delete(category1);
        return "The category was successfully delete";
    }
    @Override
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> findPaginated(Pageable pageable) {
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        return categoryPage;
    }
}

