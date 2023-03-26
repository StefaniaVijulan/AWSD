package com.example.OnlineShop.repository;

import com.example.OnlineShop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
  //  Customer getCustomerByUsernameCustomerAndPasswordCustomer(String username, String password);

    @Query("select a from Customer a where a.usernameCustomer =:username and a.passwordCustomer= :pass")
    Customer findCustomerByUsernameCustomerAndPasswordCustomer(String username, String pass);

    @Query("select a from Customer a where a.usernameCustomer =:username")
    Customer findUserByUsernameCustomer(String username);
}
