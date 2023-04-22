package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.user.UserLogin;
import com.example.OnlineShop.dto.user.UserRequest;
import com.example.OnlineShop.dto.user.UserResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.exception.UnsafeNewPassword;
import com.example.OnlineShop.model.User;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServiceInt{

    private final UserRepository UserRepository;

    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public UserResponse loginUser(UserLogin user) {
        String username = user.getUsernameUser();
        String password = user.getPasswordUser();
        User User = null;
        if(username != null && password != null){
            User = UserRepository.findUserByUsernameUserAndPasswordUser(username, password);
        }
        if(User == null){
            throw new Custom("This user does not exist");
        }
        UserResponse UserResponse = new UserResponse();
        UserResponse.setEmailUser(User.getEmailUser());
        UserResponse.setFirstNameUser(User.getFirstNameUser());
        UserResponse.setLastNameUser(User.getLastNameUser());

        return UserResponse;

    }

    public UserResponse registerUser(UserRequest User) {
        String username = User.getUsernameUser();
        if(username != null && !"".equals(username)){
            User User1 = UserRepository.findUserByUsernameUser(username);
            if(User1 != null){
                throw new Custom("This User already exist");
            }
        }
        User User1 = new User();
        User1.setFirstNameUser(User.getFirstNameUser());
        User1.setLastNameUser(User.getLastNameUser());
        User1.setEmailUser(User.getEmailUser());
        User1.setUsernameUser(User.getUsernameUser());
        User1.setPasswordUser(User.getPasswordUser());
        User1.setAddressUser(User.getAddressUser());
        UserRepository.save(User1);
        UserResponse UserResponse = new UserResponse();
        UserResponse.setEmailUser(User.getEmailUser());
        UserResponse.setFirstNameUser(User.getFirstNameUser());
        UserResponse.setLastNameUser(User.getLastNameUser());
        return UserResponse;
    }

    public UserResponse editUser(UserRequest User) {
        User User1 = UserRepository.findById(User.getIdUser()).orElseThrow(
                () -> new RuntimeException("User with this id is not found"));

        User1.setAddressUser(User.getAddressUser());
        User1.setEmailUser(User.getEmailUser());
        User1.setFirstNameUser(User.getFirstNameUser());
        User1.setLastNameUser(User.getLastNameUser());
        User1.setUsernameUser(User.getUsernameUser());

        UserRepository.save(User1);

        UserResponse UserResponse = new UserResponse();
        UserResponse.setEmailUser(User1.getEmailUser());
        UserResponse.setLastNameUser(User1.getLastNameUser());
        UserResponse.setFirstNameUser(User1.getFirstNameUser());
        return UserResponse;
    }

    public String editPasswordUser(Integer idUser,String oldPass, String newPass) {
        User User1 = UserRepository.findById(idUser).orElseThrow(
                () -> new RuntimeException("User with this id is not found"));
        System.out.println(User1.getPasswordUser());
        if(!User1.getPasswordUser().equals(oldPass)){
            throw new UnsafeNewPassword("The current password does not match");
        }
        if(oldPass.equals(newPass)){
            throw new UnsafeNewPassword("This password has been used recently!");
        }
        User1.setPasswordUser(newPass);
        UserRepository.save(User1);
        return "Parola a fost schimbata cu succes";
    }

    public String deleteUser(Integer idUser){
        User User1 = UserRepository.findById(idUser).orElseThrow(
                () -> new RuntimeException("User with this id is not found"));
        UserRepository.delete(User1);
        return "The User was successfully delete";
    }

    public List<Order> orderList(Integer idUser){
        User User1=  UserRepository.findById(idUser).orElseThrow(() -> new RuntimeException("User with this id is not found"));
        return User1.getOrderList();
    }

}
