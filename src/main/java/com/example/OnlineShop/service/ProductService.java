package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.product.ProductRequest;
import com.example.OnlineShop.dto.product.ProductResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.repository.CategoryRepository;
import com.example.OnlineShop.repository.InventoryRepository;
import com.example.OnlineShop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class ProductService implements ProductServiceInt{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final InventoryRepository inventoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, InventoryRepository inventoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public ProductResponse addProduct(ProductRequest product, Integer idCategory) {
        Product product1 = productRepository.findByTitleProduct(product.getTitleProduct());
        if(product1 != null){
            log.error("A product with this name exist)");
            throw new Custom("A product with this name exist");
        }
        Category category1 = categoryRepository.findById(idCategory).orElseThrow(
                () -> new Custom("Category with this id is not found"));

        Product product2 = new Product();

        product2.setPriceProduct(product.getPriceProduct());
        product2.setTitleProduct(product.getTitleProduct());
        product2.setDescriptionProduct(product.getDescriptionProduct());
        product2.setCategory(category1);
        product2.setInventory(product.getInventory());

        inventoryRepository.save(product2.getInventory());

        ProductResponse productResponse = new ProductResponse();
        productResponse.setPriceProduct(product2.getPriceProduct());
        productResponse.setTitleProduct(product2.getTitleProduct());
        productResponse.setDescriptionProduct(product2.getDescriptionProduct());
        productRepository.save(product2);
        log.error("Product " + product.getTitleProduct() + " add!");
        return productResponse;
    }
    public ProductResponse editProduct(ProductRequest product){
        Product product1 = productRepository.findByTitleProduct(product.getTitleProduct());
        if(product1 == null){
            log.error("This product doesn't exist");
            throw new Custom("This product doesn't exist");
        }

        product1.setPriceProduct(product.getPriceProduct());
        product1.setTitleProduct(product.getTitleProduct());
        product1.setDescriptionProduct(product.getDescriptionProduct());

        productRepository.save(product1);

        ProductResponse productResponse = new ProductResponse();
        productResponse.setPriceProduct(product.getPriceProduct());
        productResponse.setTitleProduct(product.getTitleProduct());
        productResponse.setDescriptionProduct(product.getDescriptionProduct());
        log.info("Product " + product.getTitleProduct() + " edit!");
        return productResponse;
    }
    public String deleteProduct(Integer idProduct){
        Product product1 = productRepository.findById(idProduct).orElseThrow(
                () -> new RuntimeException("Product with this id is not found"));
        log.info("Product " + product1.getTitleProduct() + " delete!");
        productRepository.delete(product1);

        return "The product was successfully delete";
    }
    public List<Product> getAllProduct(){
        log.info("Get all profile done");

        return productRepository.findAll();
    }
}
