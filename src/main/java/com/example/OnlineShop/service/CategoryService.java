package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    public final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

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
    public String deleteCategory(Integer idCategory){
        Category category1 = categoryRepository.findById(idCategory).orElseThrow(
                () -> new RuntimeException("Order with this id is not found"));
        categoryRepository.delete(category1);
        return "The category was successfully delete";
    }
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public List<Category> getAllCategoryWithASpecificName(String nameCategory){
        List<Category> categoryList = new ArrayList<>();
        for(int i=0; i<categoryRepository.findAll().size(); i++){
            String[] categoryComponent;
            categoryComponent = categoryRepository.findAll().get(i).getNameCategory().split(" ");
            for(int j=0; j< categoryComponent.length; j++) {
                if (categoryComponent[j].toLowerCase().equals(nameCategory.toLowerCase())) {
                    categoryList.add(categoryRepository.findAll().get(i));
                    break;
                }
            }
        }
        return categoryList;
    }

}
