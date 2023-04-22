package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.order.OrderRequest;
import com.example.OnlineShop.dto.order.OrderResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.User;
import com.example.OnlineShop.repository.OrderRepository;
import com.example.OnlineShop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService implements OrderServiceInt{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public OrderResponse addOrder(OrderRequest order, Integer idUser){
        User user = userRepository.findById(idUser).orElseThrow(
                () -> new Custom("This User id is not found"));

        Order order1 = new Order();

        order1.setUser(user);
        order1.setDateOrder(order.getDateOrder());
        order1.setVoucherOrder(order.getVoucherOrder());
        order1.setPriceOrder(order.getPriceOrder());
        order1.setTaxPriceOrder(order.getTaxPriceOrder());
        order1.setTotalPriceOrder(order.getTotalPriceOrder());
        order1.setProducts(order.getProducts());

        orderRepository.save(order1);

//        order.setProducts(productList);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setDateOrder(order1.getDateOrder());
        orderResponse.setTotalPriceOrder(order1.getTotalPriceOrder());

        log.info("Order of. " + order.getTotalPriceOrder() + " was successfully added" );
        return orderResponse;
    }

    @Override
    public OrderResponse editOrder(OrderRequest order, Integer idOrder){
        Order order1 = orderRepository.findById(idOrder).orElseThrow(
                () -> new Custom("Order with this id is not found"));
        order1.setVoucherOrder(order.getVoucherOrder());
        order1.setDateOrder(order.getDateOrder());
        order1.setPriceOrder(order.getPriceOrder());
        order1.setTaxPriceOrder(order.getTaxPriceOrder());
        order1.setTotalPriceOrder(order.getTotalPriceOrder());

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setDateOrder(order1.getDateOrder());
        orderResponse.setTotalPriceOrder(order1.getTotalPriceOrder());

        orderRepository.save(order1);
        return orderResponse;
    }

    @Override
    public String deleteOrder(Integer idOrder){
        Order order1 = orderRepository.findById(idOrder).orElseThrow(
                () -> new RuntimeException("Order with this id is not found"));
        orderRepository.delete(order1);
        return "The order was successfully delete";
    }

    @Override
    public List<Order> orderList(){
      return  orderRepository.findAll();
    }

    @Override
    public Page<Order> findPaginated(Pageable pageable) {
        Page<Order> orderPage = orderRepository.findAll(pageable);
        return orderPage;
    }
}
