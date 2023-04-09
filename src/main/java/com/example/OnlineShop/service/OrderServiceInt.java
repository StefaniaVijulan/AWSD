package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.order.OrderRequest;
import com.example.OnlineShop.dto.order.OrderResponse;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Product;

import java.util.List;

public interface OrderServiceInt {

    public OrderResponse addOrder(OrderRequest order, Integer idCustomer);
    public OrderResponse editOrder(OrderRequest order, Integer idOrder);
    public String deleteOrder(Integer idOrder);
    public List<Order> orderList();
    public List<Product> productList(Integer idOrder);
    public String editVoucher(Integer idOrder, Double newVoucher);
}
