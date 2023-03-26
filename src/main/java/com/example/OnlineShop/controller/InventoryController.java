package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.inventory.InventoryRequest;
import com.example.OnlineShop.dto.inventory.InventoryResponse;
import com.example.OnlineShop.model.Inventory;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.repository.InventoryRepository;
import com.example.OnlineShop.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @PostMapping("/addInventory")
    public InventoryResponse addInventory(@RequestBody InventoryRequest inventory){
        return inventoryService.addInventory(inventory);
    }

    @PutMapping("/editInventory")
    public InventoryResponse editInventory(@RequestBody InventoryRequest inventory, @RequestParam Integer idInventory){
        return inventoryService.editInventory(inventory, idInventory);
    }

    @DeleteMapping("/deleteInventory")
    public String deleteInventory(@RequestParam Integer idInventory){
        return inventoryService.deleteInventory(idInventory);
    }

    @GetMapping("/getAllInventory")
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @GetMapping("/getAllInventoryWhereSalesIsEmpty")
    public List<Inventory> getAllInventoryWhereSalesIsEmpty(){
        return inventoryService.getAllInventoryWhereSalesIsMoreThenOne();
    }
    @GetMapping("/getAllInventoryWhereQuantityProductIsEmpty")
    public List<Inventory> getAllInventoryWhereQuantityProductIsEmpty(){
        return inventoryService.getAllInventoryWhereQuantityProductIsMoreThenOne();
    }
}
