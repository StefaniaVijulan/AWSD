package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.user.UserLogin;
import com.example.OnlineShop.dto.user.UserRequest;
import com.example.OnlineShop.dto.user.UserResponse;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserServiceInt  {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public User loginUser(String username, String pass);
    public UserResponse registerUser(UserRequest User) ;
    public UserResponse editUser(UserRequest User);
    public String editPasswordUser(Integer idUser,String oldPass, String newPass);
    public String deleteUser(Integer idUser);
    public List<Order> orderList(Integer idUser);
}
