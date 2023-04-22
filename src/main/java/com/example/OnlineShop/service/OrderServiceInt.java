package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.order.OrderRequest;
import com.example.OnlineShop.dto.order.OrderResponse;
import com.example.OnlineShop.model.Inventory;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderServiceInt {

    public OrderResponse addOrder(OrderRequest order, Integer idUser);
    public OrderResponse editOrder(OrderRequest order, Integer idOrder);
    public String deleteOrder(Integer idOrder);
    public List<Order> orderList();
    Page<Order> findPaginated(Pageable pageable);
}
