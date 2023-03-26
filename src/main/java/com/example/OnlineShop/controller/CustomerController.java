package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.customer.CustomerLogin;
import com.example.OnlineShop.dto.customer.CustomerRequest;
import com.example.OnlineShop.dto.customer.CustomerResponse;
import com.example.OnlineShop.model.Customer;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/login")
    public CustomerResponse loginCustomer(@RequestBody @Valid CustomerLogin customerRequest) throws Exception {
        return customerService.loginCustomer(customerRequest);
    }

    @PostMapping("/register")
    public CustomerResponse registerCustomer(@RequestBody @Valid CustomerRequest customer) throws Exception {

        return customerService.registerCustomer(customer);
    }

    @PutMapping("/editCustomer")
    public CustomerResponse editCustomer(@RequestBody CustomerRequest customer) throws Exception {
        return customerService.editCustomer(customer);
    }

    @PutMapping("/editPasswordCustomer")
    public String editPasswordCustomer(@RequestParam Integer idCustomer,
                                      @RequestParam  String oldPass,
                                      @RequestParam String newPass ){
        return customerService.editPasswordCustomer(idCustomer,oldPass, newPass);
    }

    @DeleteMapping("/deleteCustomer/{idCustomer}")
    public String deleteCustomer(@PathVariable Integer idCustomer){
        return customerService.deleteCustomer(idCustomer);
    }

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrder(@RequestParam Integer idCustomer){
        return customerService.orderList(idCustomer);
    }
}
