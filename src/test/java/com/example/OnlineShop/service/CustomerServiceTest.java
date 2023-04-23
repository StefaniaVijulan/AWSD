package com.example.OnlineShop.service;


import com.example.OnlineShop.dto.user.UserLogin;
import com.example.OnlineShop.dto.user.UserResponse;
import com.example.OnlineShop.dto.user.UserRequest;
import com.example.OnlineShop.model.User;
import com.example.OnlineShop.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @Test
    @DisplayName("Login customer Test")
    void loginCustomer() throws Exception {
        //mock entity
        User user = new User();
        user.setAddressUser("Targu Jiu, Gorj");
        user.setEmailUser("test@gmail.com");
        user.setPasswordUser("parola");
        user.setUsernameUser("test");
        user.setLastNameUser("Test");
        user.setFirstNameUser("Test");

        //mock response
        UserLogin userLogin = new UserLogin("test", "parola");
        //mock request
        UserResponse userResponse = new UserResponse("Test", "Test", "test@gmail.com");
        lenient().when(userRepository.findUserByUsernameUserAndPasswordUser("test", "parola")).thenReturn(user);

        lenient().when(userRepository.save(user)).thenReturn(user);
        User actual = userService.loginUser(userLogin.getUsernameUser(), userLogin.getPasswordUser());
        assertEquals(actual, userResponse);


    }

    @Test
    @DisplayName("Login customer Test")
    void registerCustomer() throws Exception {
        //mock entity
        User user = new User();
        user.setIdUser(1);
        user.setAddressUser("Targu Jiu, Gorj");
        user.setEmailUser("test@gmail.com");
        user.setPasswordUser("parola");
        user.setUsernameUser("test");
        user.setLastNameUser("Test");
        user.setFirstNameUser("Test");

        //mock response
        UserRequest customerRequest = new UserRequest(1, "Test", "Test", "test@gmail.com", "test 2", "parola", "Targu Jiu, Gorj");
        //mock request
        UserResponse userResponse = new UserResponse("Test", "Test", "test@gmail.com");
        lenient().when(userRepository.findUserByUsernameUser("test")).thenReturn(user);

        lenient().when(userRepository.save(user)).thenReturn(user);
        UserResponse actual = userService.registerUser(customerRequest);
        assertEquals(actual, userResponse);


    }

    @Test
    @DisplayName("Edit category - Test")
    void editCategory() throws Exception {
        //mock entity
        User user = new User();
        user.setIdUser(1);
        user.setAddressUser("Targu Jiu, Gorj");
        user.setEmailUser("test@gmail.com");
        user.setPasswordUser("parola");
        user.setUsernameUser("test");
        user.setLastNameUser("Test");
        user.setFirstNameUser("Test");

        //mock response
        UserRequest userRequest = new UserRequest(1, "Test", "Test 2", "test@gmail.com", "test", "parola", "Targu Jiu, Gorj");
        //mock request
        UserResponse userResponse = new UserResponse("Test", "Test 2", "test@gmail.com");
        lenient().when(userRepository.findById(1)).thenReturn(java.util.Optional.of(user));

        lenient().when(userRepository.save(user)).thenReturn(user);
        UserResponse actual = userService.editUser(userRequest);
        assertEquals(actual, userResponse);

    }

//    @Test
//    @DisplayName("Get all category - Test")
//    void getAllCategory(){
//        List<Customer> customerList = new ArrayList<>();
//        Customer customer = new Customer();
//        user.setAddressCustomer("Targu Jiu, Gorj");
//        user.setEmailCustomer("test@gmail.com");
//        user.setPasswordCustomer("parola");
//        user.setUsernameCustomer("test");
//        user.setLastNameCustomer("Test");
//        user.setFirstNameCustomer("Test");
//        customerList.add(customer);
//
//        user.setAddressCustomer("Targu Jiu, Gorj");
//        user.setEmailCustomer("test@gmail.com");
//        user.setPasswordCustomer("parola");
//        user.setUsernameCustomer("test2");
//        user.setLastNameCustomer("Test2");
//        user.setFirstNameCustomer("Test2");
//        customerList.add(customer);
//
//        when(customerRepository.findAll()).thenReturn(customerList);
//        List<Customer> categories = customerService.();
//        assertEquals(categories, categoryList);
//    }

    @Test
    @DisplayName("Delete category - Test")
    void deleteCategory() {

        User user = new User();
        user.setIdUser(1);
        user.setAddressUser("Targu Jiu, Gorj");
        user.setEmailUser("test@gmail.com");
        user.setPasswordUser("parola");
        user.setUsernameUser("test");
        user.setLastNameUser("Test");
        user.setFirstNameUser("Test");

        when(userRepository.findById(user.getIdUser())).thenReturn(Optional.ofNullable(user));

        String result = userService.deleteUser(user.getIdUser());
        assertEquals(result, "The user was successfully delete");

    }
}
