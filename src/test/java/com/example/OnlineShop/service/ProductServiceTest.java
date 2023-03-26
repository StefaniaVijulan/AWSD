package com.example.OnlineShop.service;


import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.dto.product.ProductRequest;
import com.example.OnlineShop.dto.product.ProductResponse;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.model.Inventory;
import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.repository.CategoryRepository;
import com.example.OnlineShop.repository.InventoryRepository;
import com.example.OnlineShop.repository.ProductRepository;
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
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;




    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private InventoryRepository inventoryRepository;

    @Test
    @DisplayName("New product Test")
    void addProduct() throws Exception {
        //mock entity
        Category category = new Category();
        category.setIdCategory(2);
        category.setNameCategory("Bluza");

        Inventory inventory = new Inventory();
        inventory.setIdInventory(3);
        inventory.setSalesProduct(100);
        inventory.setSalesProduct(50);

        Product product = new Product();
        product.setIdProduct(1);
        product.setTitleProduct("Bluza roz");
        product.setPriceProduct(150.0);
        product.setDescriptionProduct("Descriere pentru bluza de bumbac");
        product.setCategory(category);
        product.setInventory(inventory);

        //mock response
        ProductResponse productResponse = new ProductResponse();
        productResponse.setTitleProduct("Bluza roz");
        productResponse.setPriceProduct(150.0);
        productResponse.setDescriptionProduct("Descriere pentru bluza de bumbac");
        //mock request
        ProductRequest productRequest = new ProductRequest();
        productRequest.setTitleProduct("Bluza roz");
        productRequest.setPriceProduct(150.0);
        productRequest.setDescriptionProduct("Descriere pentru bluza de bumbac");
        productRequest.setCategory(category);
        productRequest.setInventory(inventory);

        lenient().when(categoryRepository.findById(2)).thenReturn(java.util.Optional.of(category));

        lenient().when(productRepository.findById(1)).thenReturn(java.util.Optional.of(product));
        lenient().when(productRepository.save(product)).thenReturn(product);

        ProductResponse actual = productService.addProduct(productRequest, category.getIdCategory());

        System.out.println(productService.getAllProduct());
        assertEquals(actual, productResponse);
    }

    @Test
    @DisplayName("Edit category - Test")
    void editProduct() {

        //mock entity
        Category category = new Category();
        category.setIdCategory(2);
        category.setNameCategory("Bluza");

        Inventory inventory = new Inventory();
        inventory.setIdInventory(3);
        inventory.setSalesProduct(100);
        inventory.setSalesProduct(50);

        Product product = new Product();
        product.setIdProduct(1);
        product.setTitleProduct("Bluza roz");
        product.setPriceProduct(150.0);
        product.setDescriptionProduct("Descriere pentru bluza de bumbac");
        product.setCategory(category);
        product.setInventory(inventory);

        //mock response
        ProductResponse productResponse = new ProductResponse();
        productResponse.setTitleProduct("Bluza roz");
        productResponse.setPriceProduct(150.0);
        productResponse.setDescriptionProduct("Descriere pentru bluza de bumbac");
        //mock request
        ProductRequest productRequest = new ProductRequest();
        productRequest.setTitleProduct("Bluza roz");
        productRequest.setPriceProduct(150.0);
        productRequest.setDescriptionProduct("Descriere pentru bluza de bumbac");
        productRequest.setCategory(category);
        productRequest.setInventory(inventory);


        System.out.println(product);
        lenient().when(productRepository.findByTitleProduct("Bluza roz")).thenReturn(product);

        lenient().when(productRepository.save(product)).thenReturn(product);

        System.out.println(productRepository.findById(1));
        ProductResponse actual = productService.editProduct(productRequest);


       // System.out.println(actual.getTitleProduct());
        System.out.println(productResponse.getTitleProduct());
        assertEquals(actual, productResponse);

    }

    @Test
    @DisplayName("Get all products - Test")
    void getAllCategory() {
        List<Product> productList = new ArrayList<>();
        Category category = new Category();

        category.setIdCategory(2);
        category.setNameCategory("Bluza");

        Inventory inventory = new Inventory();
        inventory.setIdInventory(3);
        inventory.setSalesProduct(100);
        inventory.setSalesProduct(50);

        Product product = new Product();
        product.setIdProduct(1);
        product.setTitleProduct("Bluza roz");
        product.setPriceProduct(150.0);
        product.setDescriptionProduct("Descriere pentru bluza de bumbac");
        product.setCategory(category);
        product.setInventory(inventory);
        productList.add(product);

        product.setIdProduct(1);
        inventory.setIdInventory(4);
        inventory.setSalesProduct(150);
        inventory.setSalesProduct(70);
        product.setTitleProduct("Bluza verde");
        product.setPriceProduct(250.0);
        product.setDescriptionProduct("Descriere pentru bluza de bumbac verde");
        product.setCategory(category);
        product.setInventory(inventory);
        productList.add(product);

        when(productRepository.findAll()).thenReturn(productList);
        List<Product> products = productService.getAllProduct();
        assertEquals(products, productList);
    }

    @Test
    @DisplayName("Delete product - Test")
    void deleteCategory() {

        Category category = new Category();

        category.setIdCategory(2);
        category.setNameCategory("Bluza");

        Inventory inventory = new Inventory();
        inventory.setIdInventory(3);
        inventory.setSalesProduct(100);
        inventory.setSalesProduct(50);

        Product product = new Product();
        product.setIdProduct(1);
        product.setTitleProduct("Bluza roz");
        product.setPriceProduct(150.0);
        product.setDescriptionProduct("Descriere pentru bluza de bumbac");
        product.setCategory(category);
        product.setInventory(inventory);

        when(productRepository.findById(product.getIdProduct())).thenReturn(Optional.ofNullable(product));

        String result = productService.deleteProduct(product.getIdProduct());
        assertEquals(result, "The product was successfully delete");

    }



}