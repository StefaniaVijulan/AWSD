package com.example.OnlineShop.controller;


import com.example.OnlineShop.dto.user.UserLogin;
import com.example.OnlineShop.dto.user.UserRequest;
import com.example.OnlineShop.dto.user.UserResponse;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.service.UserServiceInt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceInt userServiceInt;

    public UserController(UserServiceInt userServiceInt) {
        this.userServiceInt = userServiceInt;
    }


    @PostMapping("/login")
    public UserResponse loginUser(@RequestBody @Valid UserLogin userRequest) throws Exception {
        return userServiceInt.loginUser(userRequest);
    }

    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody @Valid UserRequest user) throws Exception {

        return userServiceInt.registerUser(user);
    }

    @PutMapping
    public UserResponse editUser(@RequestBody UserRequest user) throws Exception {
        return userServiceInt.editUser(user);
    }

    @PutMapping("/change_password")
    public String editPasswordUser(@RequestParam Integer idUser,
                                       @RequestParam  String oldPass,
                                       @RequestParam String newPass ){
        return userServiceInt.editPasswordUser(idUser,oldPass, newPass);
    }

    @DeleteMapping("/{idUser}")
    public String deleteUser(@PathVariable Integer idUser){
        return userServiceInt.deleteUser(idUser);
    }

    @GetMapping
    public List<Order> getAllOrder(@RequestParam Integer idUser){
        return userServiceInt.orderList(idUser);
    }
}
