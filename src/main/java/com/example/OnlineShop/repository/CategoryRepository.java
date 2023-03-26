package com.example.OnlineShop.repository;

import com.example.OnlineShop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Integer> {

    @Query("select a from Category a where a.nameCategory = :nameCategory")
    Category findByNameCategory(String nameCategory);
}
