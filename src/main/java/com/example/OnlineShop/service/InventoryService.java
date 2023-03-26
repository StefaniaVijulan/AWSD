package com.example.OnlineShop.service;


import com.example.OnlineShop.dto.inventory.InventoryRequest;
import com.example.OnlineShop.dto.inventory.InventoryResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.model.Category;
import com.example.OnlineShop.model.Inventory;
import com.example.OnlineShop.repository.InventoryRepository;
import com.example.OnlineShop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    public final InventoryRepository inventoryRepository;

    public final ProductRepository productRepository;

    public InventoryService(InventoryRepository inventoryRepository, ProductRepository productRepository) {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }

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
    public String deleteInventory(Integer idInventory){
        Inventory inventory = inventoryRepository.findById(idInventory).orElseThrow(
                () -> new RuntimeException("Inventory with this id is not found"));
        inventoryRepository.delete(inventory);
        return "The inventory was successfully delete";
    }
    public List<Inventory> getAllInventory(){
        return inventoryRepository.findAll();
    }
    public List<Inventory> getAllInventoryWhereSalesIsMoreThenOne(){
        List<Inventory> inventoryList = new ArrayList<>();
        for (int i=0; i<inventoryRepository.findAll().size(); i++){
            if(inventoryRepository.findAll().get(i).getSalesProduct() == 1){
                inventoryList.add(inventoryRepository.findAll().get(i));

            }
        }
        return inventoryList;
    }
    public List<Inventory> getAllInventoryWhereQuantityProductIsMoreThenOne(){
        List<Inventory> inventoryList = new ArrayList<>();
        for (int i=0; i<inventoryRepository.findAll().size(); i++){
            if(inventoryRepository.findAll().get(i).getQuantityProduct() == 1){
                inventoryList.add(inventoryRepository.findAll().get(i));

            }
        }
        return inventoryList;
    }
}
