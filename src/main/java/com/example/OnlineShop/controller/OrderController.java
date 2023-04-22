package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.order.OrderRequest;
import com.example.OnlineShop.dto.order.OrderResponse;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.service.OrderServiceInt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderServiceInt orderServiceInt;

    public OrderController(OrderServiceInt orderServiceInt) {
        this.orderServiceInt = orderServiceInt;
    }


    @PostMapping
    public OrderResponse addOrder(@RequestBody @Valid OrderRequest order, @RequestParam Integer idUser){
        return orderServiceInt.addOrder(order, idUser);
    }

    @PutMapping
    public OrderResponse editOrder(@RequestBody OrderRequest order, @RequestParam Integer idOrder){
        return  orderServiceInt.editOrder(order, idOrder);
    }

    @DeleteMapping
    public String deleteOrder(@RequestParam Integer idOrder){
        return orderServiceInt.deleteOrder(idOrder);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderServiceInt.orderList();
    }

}
