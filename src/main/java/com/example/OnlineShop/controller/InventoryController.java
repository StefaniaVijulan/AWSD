package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.inventory.InventoryRequest;
import com.example.OnlineShop.dto.inventory.InventoryResponse;
import com.example.OnlineShop.model.Inventory;
import com.example.OnlineShop.service.InventoryServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryServiceInt inventoryServiceInt;

    public InventoryController(InventoryServiceInt inventoryServiceInt) {
        this.inventoryServiceInt = inventoryServiceInt;
    }

    @PostMapping
    public InventoryResponse addInventory(@RequestBody InventoryRequest inventory){
        return inventoryServiceInt.addInventory(inventory);
    }

    @PutMapping
    public InventoryResponse editInventory(@RequestBody InventoryRequest inventory, @RequestParam Integer idInventory){
        return inventoryServiceInt.editInventory(inventory, idInventory);
    }

    @DeleteMapping
    public String deleteInventory(@RequestParam Integer idInventory){
        return inventoryServiceInt.deleteInventory(idInventory);
    }

    @GetMapping
    public List<Inventory> getAllInventory(){
        return inventoryServiceInt.getAllInventory();
    }

    @GetMapping("/salesIs_empty")
    public List<Inventory> getAllInventoryWhereSalesIsEmpty(){
        return inventoryServiceInt.getAllInventoryWhereSalesIsMoreThenOne();
    }
    @GetMapping("/quantity_product_empty")
    public List<Inventory> getAllInventoryWhereQuantityProductIsEmpty(){
        return inventoryServiceInt.getAllInventoryWhereQuantityProductIsMoreThenOne();
    }
}
