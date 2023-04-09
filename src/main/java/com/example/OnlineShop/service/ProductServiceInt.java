package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.product.ProductRequest;
import com.example.OnlineShop.dto.product.ProductResponse;
import com.example.OnlineShop.model.Product;

import java.util.List;

public interface ProductServiceInt {
    public ProductResponse addProduct(ProductRequest product, Integer idCategory) ;
    public ProductResponse editProduct(ProductRequest product);
    public String deleteProduct(Integer idProduct);
    public List<Product> getAllProduct();
    public List<Product> getAllProductWithPriceBiggerThenAValue(Double value);
    public String editCurrentCategory(Integer idProduct, Integer newCategory);
}
