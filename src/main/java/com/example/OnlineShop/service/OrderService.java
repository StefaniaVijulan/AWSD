package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.order.OrderRequest;
import com.example.OnlineShop.dto.order.OrderResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.model.Customer;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.Product;
import com.example.OnlineShop.repository.CustomerRepository;
import com.example.OnlineShop.repository.OrderRepository;
import com.example.OnlineShop.repository.ProductRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public OrderResponse addOrder(OrderRequest order, Integer idCustomer){
        Customer customer = customerRepository.findById(idCustomer).orElseThrow(
                () -> new Custom("This customer id is not found"));

        Order order1 = new Order();

        order1.setCustomer(customer);
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

        return orderResponse;
    }

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

    public String deleteOrder(Integer idOrder){
        Order order1 = orderRepository.findById(idOrder).orElseThrow(
                () -> new RuntimeException("Order with this id is not found"));
        orderRepository.delete(order1);
        return "The order was successfully delete";
    }

    public List<Order> orderList(){
      return  orderRepository.findAll();
    }

    public List<Product> productList(Integer idOrder){
        Order order = orderRepository.findById(idOrder).orElseThrow(
                () -> new Custom("This order id is not found"));
        return order.getProducts();
    }
    public String editVoucher(Integer idOrder, Double newVoucher){
        Order order1 = orderRepository.findById(idOrder).orElseThrow(
                () -> new RuntimeException("Order with this id is not found"));
        order1.setVoucherOrder(newVoucher);
        orderRepository.save(order1);
        return "Edit done";

    }
}
