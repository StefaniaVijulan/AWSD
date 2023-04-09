package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.customer.CustomerLogin;
import com.example.OnlineShop.dto.customer.CustomerRequest;
import com.example.OnlineShop.dto.customer.CustomerResponse;
import com.example.OnlineShop.model.Order;

import java.util.List;

public interface CustomerServiceInt {

    public CustomerResponse loginCustomer(CustomerLogin user);
    public CustomerResponse registerCustomer(CustomerRequest customer) ;
    public CustomerResponse editCustomer(CustomerRequest customer);
    public String editPasswordCustomer(Integer idCustomer,String oldPass, String newPass);
    public String deleteCustomer(Integer idCustomer);
    public List<Order> orderList(Integer idCustomer);
}
