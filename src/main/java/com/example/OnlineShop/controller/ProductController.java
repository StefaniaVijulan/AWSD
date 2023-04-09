package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.product.ProductRequest;
import com.example.OnlineShop.dto.product.ProductResponse;
import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.service.ProductServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceInt productServiceInt;

    public ProductController(ProductServiceInt productServiceInt) {
        this.productServiceInt = productServiceInt;
    }


    @PostMapping
    public ProductResponse addProduct(@RequestBody ProductRequest product, @RequestParam Integer idCategory) throws Exception {
        return productServiceInt.addProduct(product, idCategory);
    }
    @PutMapping
    public ProductResponse editProduct(@RequestBody ProductRequest product){
        return productServiceInt.editProduct(product);
    }
    @DeleteMapping
    public String deleteProduct(@RequestParam Integer idProduct) {
        return productServiceInt.deleteProduct(idProduct);
    }
    @GetMapping
    public List<Product> listOfProducts() throws Exception {
        return productServiceInt.getAllProduct();
    }
    @GetMapping("/price_bigger_then_value")
    public List<Product> getAllProductWithPriceBiggerThenAValue(@RequestParam Double value) throws Exception {
        return productServiceInt.getAllProductWithPriceBiggerThenAValue(value);
    }
    @PutMapping("/category")
    public String editCurrentCategory(@RequestParam Integer idProduct, @RequestParam Integer newCategory){
        return productServiceInt.editCurrentCategory(idProduct, newCategory);
    }


}
