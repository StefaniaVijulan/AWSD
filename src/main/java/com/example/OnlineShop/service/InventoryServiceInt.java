package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.inventory.InventoryRequest;
import com.example.OnlineShop.dto.inventory.InventoryResponse;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.model.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InventoryServiceInt {
    public InventoryResponse addInventory(InventoryRequest inventory);
    public InventoryResponse editInventory(InventoryRequest inventory, Integer idInventory);
    public String deleteInventory(Integer idInventory);
    public List<Inventory> getAllInventory();
    Page<Inventory> findPaginated(Pageable pageable);
}
