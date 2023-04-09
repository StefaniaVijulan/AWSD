package com.example.OnlineShop.controller;

import com.example.OnlineShop.dto.customer.CustomerLogin;
import com.example.OnlineShop.dto.customer.CustomerRequest;
import com.example.OnlineShop.dto.customer.CustomerResponse;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.service.CustomerServiceInt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceInt customerServiceInt;

    public CustomerController(CustomerServiceInt customerServiceInt) {
        this.customerServiceInt = customerServiceInt;
    }


    @PostMapping("/login")
    public CustomerResponse loginCustomer(@RequestBody @Valid CustomerLogin customerRequest) throws Exception {
        return customerServiceInt.loginCustomer(customerRequest);
    }

    @PostMapping("/register")
    public CustomerResponse registerCustomer(@RequestBody @Valid CustomerRequest customer) throws Exception {

        return customerServiceInt.registerCustomer(customer);
    }

    @PutMapping
    public CustomerResponse editCustomer(@RequestBody CustomerRequest customer) throws Exception {
        return customerServiceInt.editCustomer(customer);
    }

    @PutMapping("/change_password")
    public String editPasswordCustomer(@RequestParam Integer idCustomer,
                                      @RequestParam  String oldPass,
                                      @RequestParam String newPass ){
        return customerServiceInt.editPasswordCustomer(idCustomer,oldPass, newPass);
    }

    @DeleteMapping("/{idCustomer}")
    public String deleteCustomer(@PathVariable Integer idCustomer){
        return customerServiceInt.deleteCustomer(idCustomer);
    }

    @GetMapping
    public List<Order> getAllOrder(@RequestParam Integer idCustomer){
        return customerServiceInt.orderList(idCustomer);
    }
}
