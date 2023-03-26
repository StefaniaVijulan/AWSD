package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.category.CategoryRequest;
import com.example.OnlineShop.dto.category.CategoryResponse;
import com.example.OnlineShop.dto.inventory.InventoryRequest;
import com.example.OnlineShop.dto.inventory.InventoryResponse;
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
public class InventoryServiceTest {

    @InjectMocks
    private InventoryService inventoryService;

    @Mock
    private InventoryRepository inventoryRepository;


    @Test
    @DisplayName("New inventory Test")
    void addInventory() {
        //mock entity

        Inventory inventory = new Inventory();
        inventory.setSalesProduct(150);
        inventory.setQuantityProduct(15);

        //mock response
        InventoryResponse inventoryResponse = new InventoryResponse(150, 15);
        //mock request
        InventoryRequest inventoryRequest = new InventoryRequest(150, 15);

        lenient().when(inventoryRepository.save(inventory)).thenReturn(inventory);
        InventoryResponse actual = inventoryService.addInventory(inventoryRequest);
        assertEquals(actual, inventoryResponse);
    }

    @Test
    @DisplayName("Edit inventory - Test")
    void editInventory(){

        //mock entity

        Inventory inventory = new Inventory();
        inventory.setIdInventory(1);
        inventory.setSalesProduct(150);
        inventory.setQuantityProduct(15);

        //mock response
        InventoryResponse inventoryResponse = new InventoryResponse(155, 15);


        //mock request
        InventoryRequest inventoryRequest = new InventoryRequest(155, 15);



        lenient().when(inventoryRepository.findById(1)).thenReturn(java.util.Optional.of(inventory));
        lenient().when(inventoryRepository.save(inventory)).thenReturn(inventory);

        InventoryResponse actual = inventoryService.editInventory(inventoryRequest,1);
        assertEquals(actual, inventoryResponse);


    }

    @Test
    @DisplayName("Get all inventory - Test")
    void getAllInventory(){
        List<Inventory> inventoryList = new ArrayList<>();
        Inventory inventory = new Inventory();

        inventory.setIdInventory(1);
        inventory.setQuantityProduct(50);
        inventory.setSalesProduct(10);
        inventoryList.add(inventory);

        inventory.setIdInventory(2);
        inventory.setQuantityProduct(250);
        inventory.setSalesProduct(100);
        inventoryList.add(inventory);

        when(inventoryRepository.findAll()).thenReturn(inventoryList);
        List<Inventory> inventories = inventoryService.getAllInventory();
        assertEquals(inventories, inventoryList);
    }

    @Test
    @DisplayName("Delete inventory - Test")
    void deleteInventory(){

        Inventory inventory = new Inventory();
        inventory.setIdInventory(1);
        inventory.setSalesProduct(150);
        inventory.setQuantityProduct(15);

        when(inventoryRepository.findById(inventory.getIdInventory())).thenReturn(Optional.ofNullable(inventory));

        String result = inventoryService.deleteInventory(inventory.getIdInventory());
        assertEquals(result, "The inventory was successfully delete");

    }
}