package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.product.ProductRequest;
import com.example.OnlineShop.dto.product.ProductResponse;
import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/addProduct")
    public ProductResponse addProduct(@RequestBody ProductRequest product, @RequestParam Integer idCategory) throws Exception {
        return productService.addProduct(product, idCategory);
    }
    @PutMapping("/editProduct")
    public ProductResponse editProduct(@RequestBody ProductRequest product){
        return productService.editProduct(product);
    }
    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Integer idProduct) {
        return productService.deleteProduct(idProduct);
    }
    @GetMapping("/getAllProduct")
    public List<Product> listOfProducts() throws Exception {
        return productService.getAllProduct();
    }
    @GetMapping("/getAllProductWithPriceBiggerThenAValue")
    public List<Product> getAllProductWithPriceBiggerThenAValue(@RequestParam Double value) throws Exception {
        return productService.getAllProductWithPriceBiggerThenAValue(value);
    }
    @PutMapping("/editCurrentCategory")
    public String editCurrentCategory(@RequestParam Integer idProduct, @RequestParam Integer newCategory){
        return productService.editCurrentCategory(idProduct, newCategory);
    }


}
