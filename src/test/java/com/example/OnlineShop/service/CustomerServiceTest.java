package com.example.OnlineShop.service;


import com.example.OnlineShop.dto.customer.CustomerLogin;
import com.example.OnlineShop.dto.customer.CustomerRequest;
import com.example.OnlineShop.dto.customer.CustomerResponse;
import com.example.OnlineShop.model.Customer;
import com.example.OnlineShop.repository.CustomerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;


    @Test
    @DisplayName("Login customer Test")
    void loginCustomer() throws Exception {
        //mock entity
        Customer customer = new Customer();
        customer.setAddressCustomer("Targu Jiu, Gorj");
        customer.setEmailCustomer("test@gmail.com");
        customer.setPasswordCustomer("parola");
        customer.setUsernameCustomer("test");
        customer.setLastNameCustomer("Test");
        customer.setFirstNameCustomer("Test");

        //mock response
        CustomerLogin customerLogin = new CustomerLogin("test", "parola");
        //mock request
        CustomerResponse customerResponse = new CustomerResponse("Test", "Test", "test@gmail.com");
        lenient().when(customerRepository.findCustomerByUsernameCustomerAndPasswordCustomer("test", "parola")).thenReturn(customer);

        lenient().when(customerRepository.save(customer)).thenReturn(customer);
        CustomerResponse actual = customerService.loginCustomer(customerLogin);
        assertEquals(actual, customerResponse);


    }

    @Test
    @DisplayName("Login customer Test")
    void registerCustomer() throws Exception {
        //mock entity
        Customer customer = new Customer();
        customer.setIdCustomer(1);
        customer.setAddressCustomer("Targu Jiu, Gorj");
        customer.setEmailCustomer("test@gmail.com");
        customer.setPasswordCustomer("parola");
        customer.setUsernameCustomer("test");
        customer.setLastNameCustomer("Test");
        customer.setFirstNameCustomer("Test");

        //mock response
        CustomerRequest customerRequest = new CustomerRequest(1, "Test", "Test", "test@gmail.com", "test 2", "parola", "Targu Jiu, Gorj");
        //mock request
        CustomerResponse customerResponse = new CustomerResponse("Test", "Test", "test@gmail.com");
        lenient().when(customerRepository.findUserByUsernameCustomer("test")).thenReturn(customer);

        lenient().when(customerRepository.save(customer)).thenReturn(customer);
        CustomerResponse actual = customerService.registerCustomer(customerRequest);
        assertEquals(actual, customerResponse);


    }

    @Test
    @DisplayName("Edit category - Test")
    void editCategory() throws Exception {
        //mock entity
        Customer customer = new Customer();
        customer.setIdCustomer(1);
        customer.setAddressCustomer("Targu Jiu, Gorj");
        customer.setEmailCustomer("test@gmail.com");
        customer.setPasswordCustomer("parola");
        customer.setUsernameCustomer("test");
        customer.setLastNameCustomer("Test");
        customer.setFirstNameCustomer("Test");

        //mock response
        CustomerRequest customerRequest = new CustomerRequest(1, "Test", "Test 2", "test@gmail.com", "test", "parola", "Targu Jiu, Gorj");
        //mock request
        CustomerResponse customerResponse = new CustomerResponse("Test", "Test 2", "test@gmail.com");
        lenient().when(customerRepository.findById(1)).thenReturn(java.util.Optional.of(customer));

        lenient().when(customerRepository.save(customer)).thenReturn(customer);
        CustomerResponse actual = customerService.editCustomer(customerRequest);
        assertEquals(actual, customerResponse);

    }

//    @Test
//    @DisplayName("Get all category - Test")
//    void getAllCategory(){
//        List<Customer> customerList = new ArrayList<>();
//        Customer customer = new Customer();
//        customer.setAddressCustomer("Targu Jiu, Gorj");
//        customer.setEmailCustomer("test@gmail.com");
//        customer.setPasswordCustomer("parola");
//        customer.setUsernameCustomer("test");
//        customer.setLastNameCustomer("Test");
//        customer.setFirstNameCustomer("Test");
//        customerList.add(customer);
//
//        customer.setAddressCustomer("Targu Jiu, Gorj");
//        customer.setEmailCustomer("test@gmail.com");
//        customer.setPasswordCustomer("parola");
//        customer.setUsernameCustomer("test2");
//        customer.setLastNameCustomer("Test2");
//        customer.setFirstNameCustomer("Test2");
//        customerList.add(customer);
//
//        when(customerRepository.findAll()).thenReturn(customerList);
//        List<Customer> categories = customerService.();
//        assertEquals(categories, categoryList);
//    }

    @Test
    @DisplayName("Delete category - Test")
    void deleteCategory() {

        Customer customer = new Customer();
        customer.setIdCustomer(1);
        customer.setAddressCustomer("Targu Jiu, Gorj");
        customer.setEmailCustomer("test@gmail.com");
        customer.setPasswordCustomer("parola");
        customer.setUsernameCustomer("test");
        customer.setLastNameCustomer("Test");
        customer.setFirstNameCustomer("Test");

        when(customerRepository.findById(customer.getIdCustomer())).thenReturn(Optional.ofNullable(customer));

        String result = customerService.deleteCustomer(customer.getIdCustomer());
        assertEquals(result, "The customer was successfully delete");

    }
}
