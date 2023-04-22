package com.example.OnlineShop.service;


import com.example.OnlineShop.dto.inventory.InventoryRequest;
import com.example.OnlineShop.dto.inventory.InventoryResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.model.Inventory;
import com.example.OnlineShop.repository.InventoryRepository;
import com.example.OnlineShop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService implements InventoryServiceInt{

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public InventoryResponse addInventory(InventoryRequest inventory){
      //  productRepository.save(inventory.getProduct());
        Inventory inventory1 = new Inventory();
        inventory1.setSalesProduct(inventory.getSalesProduct());
        inventory1.setQuantityProduct(inventory.getQuantityProduct());
        inventoryRepository.save(inventory1);

        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setSalesProduct(inventory.getSalesProduct());
        inventoryResponse.setQuantityProduct(inventory.getQuantityProduct());
        return inventoryResponse;
    }

    @Override
    public InventoryResponse editInventory(InventoryRequest inventory, Integer idInventory){
        Inventory inventory1 = inventoryRepository.findById(idInventory).orElseThrow(
                () -> new RuntimeException("Inventory with this id is not found"));
        inventory1.setQuantityProduct(inventory.getQuantityProduct());
        inventory1.setSalesProduct(inventory.getSalesProduct());
        inventoryRepository.save(inventory1);
        InventoryResponse inventoryResponse = new InventoryResponse();
        inventoryResponse.setSalesProduct(inventory.getSalesProduct());
        inventoryResponse.setQuantityProduct(inventory.getQuantityProduct());
        return inventoryResponse;
    }
    @Override
    public String deleteInventory(Integer idInventory){
        Inventory inventory = inventoryRepository.findById(idInventory).orElseThrow(
                () -> new RuntimeException("Inventory with this id is not found"));
        inventoryRepository.delete(inventory);
        return "The inventory was successfully delete";
    }
    @Override
    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }
    @Override
    public Page<Inventory> findPaginated(Pageable pageable) {
        Page<Inventory> inventoryPage = inventoryRepository.findAll(pageable);
        return inventoryPage;
    }
}
