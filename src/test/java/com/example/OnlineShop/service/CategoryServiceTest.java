package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;



    @Test
    @DisplayName("New category Test")
    void addCategoryHappyFlow(){
        //mock entity

        Category category = new Category();
        category.setNameCategory("Bluza de bumbac");

        //mock response
        CategoryResponse categoryResponse = new CategoryResponse("Bluza de bumbac");
        //mock request
        CategoryRequest categoryRequest = new CategoryRequest("Bluza de bumbac");

        lenient().when(categoryRepository.save(category)).thenReturn(category);
        CategoryResponse actual = categoryService.addCategory(categoryRequest);
        assertThat(actual.getNameCategory()).isEqualTo(categoryResponse.getNameCategory());

    }

    @Test
    @DisplayName("Edit category - Test")
    void editCategory(){

        //mock entity

        Category category = new Category();
        category.setIdCategory(1);
        category.setNameCategory("Bluza de bumbac");

        //mock response
        CategoryResponse categoryResponse = new CategoryResponse("Bluza de bumbac");


        //mock request
        CategoryRequest categoryRequest = new CategoryRequest("Bluza de bumbac");



        lenient().when(categoryRepository.findById(1)).thenReturn(java.util.Optional.of(category));
        lenient().when(categoryRepository.save(category)).thenReturn(category);

        CategoryResponse actual = categoryService.editCategory(categoryRequest,1);
        assertThat(actual.getNameCategory()).isEqualTo(categoryResponse.getNameCategory());


    }

    @Test
    @DisplayName("Get all category - Test")
    void getAllCategory(){
        List<Category> categoryList = new ArrayList<>();
        Category category = new Category();

        category.setIdCategory(1);
        category.setNameCategory("Bluza de bumbac");
        categoryList.add(category);
        category.setIdCategory(2);
        category.setNameCategory("Camasa de bumbac");
        categoryList.add(category);

        when(categoryRepository.findAll()).thenReturn(categoryList);
        List<Category> categories = categoryService.getAllCategory();
        assertEquals(categories, categoryList);
    }

    @Test
    @DisplayName("Delete category - Test")
    void deleteCategory(){

        Category category = new Category();
        category.setIdCategory(1);
        category.setNameCategory("Bluza de bumbac");

        when(categoryRepository.findById(category.getIdCategory())).thenReturn(Optional.ofNullable(category));

        String result = categoryService.deleteCategory(category.getIdCategory());
        assertEquals(result, "The category was successfully delete");

    }


}
