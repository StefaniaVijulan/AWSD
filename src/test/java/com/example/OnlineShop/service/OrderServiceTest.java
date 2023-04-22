package com.example.OnlineShop.service;


import com.example.OnlineShop.dto.order.OrderRequest;
import com.example.OnlineShop.dto.order.OrderResponse;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.User;
import com.example.OnlineShop.repository.OrderRepository;
import com.example.OnlineShop.repository.ProductRepository;
import com.example.OnlineShop.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;


    @Test
    @DisplayName("New order Test")
    void addOrder() {
        //mock entity

        User user = new User();
        user.setIdUser(1);
        user.setAddressUser("Targu Jiu, Gorj");
        user.setEmailUser("test@gmail.com");
        user.setPasswordUser("parola");
        user.setUsernameUser("test");
        user.setLastNameUser("Test");
        user.setFirstNameUser("Test");

        Order order = new Order();
        order.setDateOrder(new Date(2023 - 01 - 10));
        order.setPriceOrder(120.0);
        order.setTaxPriceOrder(10.0);
        order.setTotalPriceOrder(170.0);
        order.setVoucherOrder(5.0);
        order.setUser(user);
        order.setProducts(null);

        //mock response
        OrderResponse orderResponse = new OrderResponse((new Date(2023 - 01 - 10)), 170.0);
        //mock request
        OrderRequest orderRequest = new OrderRequest((new Date(2023 - 01 - 10)), 120.0, 10.0, 170.0, 5.0, null);
        lenient().when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
        lenient().when(orderRepository.save(order)).thenReturn(order);
        OrderResponse actual = orderService.addOrder(orderRequest, user.getIdUser());
        assertEquals(actual, orderResponse);
    }


    @Test
    @DisplayName("Edit order - Test")
    void editOrder() {


        User user = new User();
        user.setIdUser(1);
        user.setAddressUser("Targu Jiu, Gorj");
        user.setEmailUser("test@gmail.com");
        user.setPasswordUser("parola");
        user.setUsernameUser("test");
        user.setLastNameUser("Test");
        user.setFirstNameUser("Test");

        Order order = new Order();
        order.setIdOrder(2);
        order.setDateOrder(new Date(2023 - 01 - 10));
        order.setPriceOrder(120.0);
        order.setTaxPriceOrder(10.0);
        order.setTotalPriceOrder(170.0);
        order.setVoucherOrder(5.0);
        order.setUser(user);
        order.setProducts(null);

        //mock response
        OrderResponse orderResponse = new OrderResponse((new Date(2023 - 01 - 10)), 270.0);
        //mock request
        OrderRequest orderRequest = new OrderRequest((new Date(2023 - 01 - 10)), 120.0, 10.0, 270.0, 5.0, null);
        lenient().when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));
        lenient().when(orderRepository.findById(2)).thenReturn(java.util.Optional.of(order));
        lenient().when(orderRepository.save(order)).thenReturn(order);
        OrderResponse actual = orderService.editOrder(orderRequest, order.getIdOrder());
        assertEquals(actual, orderResponse);
    }

    @Test
    @DisplayName("Get all orders - Test")
    void getAllOrder() {
        List<Order> orderList = new ArrayList<>();
        Order order = new Order();
        User user = new User();
        user.setIdUser(1);
        user.setAddressUser("Targu Jiu, Gorj");
        user.setEmailUser("test@gmail.com");
        user.setPasswordUser("parola");
        user.setUsernameUser("test");
        user.setLastNameUser("Test");
        user.setFirstNameUser("Test");

        order.setIdOrder(2);
        order.setDateOrder(new Date(2023 - 01 - 10));
        order.setPriceOrder(120.0);
        order.setTaxPriceOrder(10.0);
        order.setTotalPriceOrder(170.0);
        order.setVoucherOrder(5.0);
        order.setUser(user);
        order.setProducts(null);
        orderList.add(order);

        order.setIdOrder(3);
        order.setDateOrder(new Date(2023 - 01 - 10));
        order.setPriceOrder(333.0);
        order.setTaxPriceOrder(10.0);
        order.setTotalPriceOrder(170.0);
        order.setVoucherOrder(25.0);
        order.setUser(user);
        order.setProducts(null);
        orderList.add(order);


        when(orderRepository.findAll()).thenReturn(orderList);
        List<Order> orders = orderService.orderList();
        assertEquals(orders, orderList);
    }


    @Test
    @DisplayName("Delete order - Test")
    void deleteOrder() {

        Order order = new Order();
        User user = new User();
        user.setIdUser(1);
        user.setAddressUser("Targu Jiu, Gorj");
        user.setEmailUser("test@gmail.com");
        user.setPasswordUser("parola");
        user.setUsernameUser("test");
        user.setLastNameUser("Test");
        user.setFirstNameUser("Test");

        order.setIdOrder(2);
        order.setDateOrder(new Date(2023 - 01 - 10));
        order.setPriceOrder(120.0);
        order.setTaxPriceOrder(10.0);
        order.setTotalPriceOrder(170.0);
        order.setVoucherOrder(5.0);
        order.setUser(user);
        order.setProducts(null);
        when(orderRepository.findById(order.getIdOrder())).thenReturn(Optional.ofNullable(order));

        String result = orderService.deleteOrder(order.getIdOrder());
        assertEquals(result, "The order was successfully delete");

    }
}