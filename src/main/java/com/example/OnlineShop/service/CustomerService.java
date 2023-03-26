package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.customer.CustomerLogin;
import com.example.OnlineShop.dto.customer.CustomerRequest;
import com.example.OnlineShop.dto.customer.CustomerResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.exception.UnsafeNewPassword;
import com.example.OnlineShop.model.Customer;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse loginCustomer(CustomerLogin user) throws Exception {
        String username = user.getUsernameCustomer();
        String password = user.getPasswordCustomer();
        Customer customer = null;
        if(username != null && password != null){
            customer = customerRepository.findCustomerByUsernameCustomerAndPasswordCustomer(username, password);
        }
        if(customer == null){
            throw new Custom("This user does not exist");
        }
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setEmailCustomer(customer.getEmailCustomer());
        customerResponse.setFirstNameCustomer(customer.getFirstNameCustomer());
        customerResponse.setLastNameCustomer(customer.getLastNameCustomer());

        return customerResponse;

    }

    public CustomerResponse registerCustomer(CustomerRequest customer) throws Exception {
        String username = customer.getUsernameCustomer();
        if(username != null && !"".equals(username)){
            Customer customer1 = customerRepository.findUserByUsernameCustomer(username);
            if(customer1 != null){
                throw new Custom("This customer already exist");
            }
        }
        Customer customer1 = new Customer();
        customer1.setFirstNameCustomer(customer.getFirstNameCustomer());
        customer1.setLastNameCustomer(customer.getLastNameCustomer());
        customer1.setEmailCustomer(customer.getEmailCustomer());
        customer1.setUsernameCustomer(customer.getUsernameCustomer());
        customer1.setPasswordCustomer(customer.getPasswordCustomer());
        customer1.setAddressCustomer(customer.getAddressCustomer());
        customerRepository.save(customer1);
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setEmailCustomer(customer.getEmailCustomer());
        customerResponse.setFirstNameCustomer(customer.getFirstNameCustomer());
        customerResponse.setLastNameCustomer(customer.getLastNameCustomer());
        return customerResponse;
    }

    public CustomerResponse editCustomer(CustomerRequest customer) throws Exception{
        Customer customer1 = customerRepository.findById(customer.getIdCustomer()).orElseThrow(
                () -> new RuntimeException("Customer with this id is not found"));

        customer1.setAddressCustomer(customer.getAddressCustomer());
        customer1.setEmailCustomer(customer.getEmailCustomer());
        customer1.setFirstNameCustomer(customer.getFirstNameCustomer());
        customer1.setLastNameCustomer(customer.getLastNameCustomer());
        customer1.setUsernameCustomer(customer.getUsernameCustomer());

        customerRepository.save(customer1);

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setEmailCustomer(customer1.getEmailCustomer());
        customerResponse.setLastNameCustomer(customer1.getLastNameCustomer());
        customerResponse.setFirstNameCustomer(customer1.getFirstNameCustomer());
        return customerResponse;
    }

    public String editPasswordCustomer(Integer idCustomer,String oldPass, String newPass) {
        Customer customer1 = customerRepository.findById(idCustomer).orElseThrow(
                () -> new RuntimeException("Customer with this id is not found"));
        System.out.println(customer1.getPasswordCustomer());
        if(!customer1.getPasswordCustomer().equals(oldPass)){
            throw new UnsafeNewPassword("The current password does not match");
        }
        if(oldPass.equals(newPass)){
            throw new UnsafeNewPassword("This password has been used recently!");
        }
        customer1.setPasswordCustomer(newPass);
        customerRepository.save(customer1);
        return "Parola a fost schimbata cu succes";
    }

    public String deleteCustomer(Integer idCustomer){
        Customer customer1 = customerRepository.findById(idCustomer).orElseThrow(
                () -> new RuntimeException("Customer with this id is not found"));
        customerRepository.delete(customer1);
        return "The customer was successfully delete";
    }

    public List<Order> orderList(Integer idCustomer){
       Customer customer1=  customerRepository.findById(idCustomer).orElseThrow(() -> new RuntimeException("Customer with this id is not found"));
        return customer1.getOrderList();
    }

}
