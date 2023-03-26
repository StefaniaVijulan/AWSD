package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.order.OrderRequest;
import com.example.OnlineShop.dto.order.OrderResponse;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addOrder")
    public OrderResponse addOrder(@RequestBody @Valid OrderRequest order, @RequestParam Integer idCustomer){
        return orderService.addOrder(order, idCustomer);
    }

    @PutMapping("/editOrder")
    public OrderResponse editOrder(@RequestBody OrderRequest order, @RequestParam Integer idOrder){
        return  orderService.editOrder(order, idOrder);
    }

    @DeleteMapping("/deleteOrder")
    public String deleteOrder(@RequestParam Integer idOrder){
        return orderService.deleteOrder(idOrder);
    }

    @GetMapping("/getAllOrder")
    public List<Order> getAllOrders(){
        return orderService.orderList();
    }

    @PutMapping("/editVoucher/{idOrder}")
    public String editVoucher(@PathVariable Integer idOrder, @RequestParam Double newVoucher){
        return orderService.editVoucher(idOrder, newVoucher);

    }
    @GetMapping("/getAllProductList")
    public List<Product> listOfProduct(@RequestParam Integer idOrder){
        return orderService.productList(idOrder);
    }

}
