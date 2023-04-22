package com.example.OnlineShop.service;

import com.example.OnlineShop.dto.user.UserLogin;
import com.example.OnlineShop.dto.user.UserRequest;
import com.example.OnlineShop.dto.user.UserResponse;
import com.example.OnlineShop.exception.Custom;
import com.example.OnlineShop.exception.UnsafeNewPassword;
import com.example.OnlineShop.model.User;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class UserService implements UserServiceInt{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse loginUser(UserLogin user) {
        String username = user.getUsernameUser();
        String password = user.getPasswordUser();
        User user1 = null;
        if(username != null && password != null){
            log.info("Se cauta user-ul in baza de date");
            user1 = userRepository.findUserByUsernameUserAndPasswordUser(username, password);
        }
        if(user1 == null){
            log.error("This user does not exist");
            throw new Custom("This user does not exist");
        }
        UserResponse userResponse = new UserResponse();
        userResponse.setEmailUser(user1.getEmailUser());
        userResponse.setFirstNameUser(user1.getFirstNameUser());
        userResponse.setLastNameUser(user1.getLastNameUser());
        log.info(userResponse.toString());
        return userResponse;

    }

    public UserResponse registerUser(UserRequest User) {
        String username = User.getUsernameUser();
        if(username != null && !"".equals(username)){
            User user1 = userRepository.findUserByUsernameUser(username);
            if(user1 != null){
                log.error("This user already exist");
                throw new Custom("This user already exist");
            }
        }
        User user1 = new User();
        user1.setFirstNameUser(User.getFirstNameUser());
        user1.setLastNameUser(User.getLastNameUser());
        user1.setEmailUser(User.getEmailUser());
        user1.setUsernameUser(User.getUsernameUser());
        user1.setPasswordUser(User.getPasswordUser());
        user1.setAddressUser(User.getAddressUser());
        userRepository.save(user1);
        UserResponse UserResponse = new UserResponse();
        UserResponse.setEmailUser(User.getEmailUser());
        UserResponse.setFirstNameUser(User.getFirstNameUser());
        UserResponse.setLastNameUser(User.getLastNameUser());
        log.info("Done creating user");
        return UserResponse;
    }

    public UserResponse editUser(UserRequest User) {
        User User1 = userRepository.findById(User.getIdUser()).orElseThrow(
                () -> new RuntimeException("User with this id is not found"));

        User1.setAddressUser(User.getAddressUser());
        User1.setEmailUser(User.getEmailUser());
        User1.setFirstNameUser(User.getFirstNameUser());
        User1.setLastNameUser(User.getLastNameUser());
        User1.setUsernameUser(User.getUsernameUser());

        userRepository.save(User1);

        UserResponse UserResponse = new UserResponse();
        UserResponse.setEmailUser(User1.getEmailUser());
        UserResponse.setLastNameUser(User1.getLastNameUser());
        UserResponse.setFirstNameUser(User1.getFirstNameUser());
        log.info("Done edit");

        return UserResponse;
    }

    public String editPasswordUser(Integer idUser,String oldPass, String newPass) {
        User User1 = userRepository.findById(idUser).orElseThrow(
                () -> new RuntimeException("User with this id is not found"));
        System.out.println(User1.getPasswordUser());
        if(!User1.getPasswordUser().equals(oldPass)){
            log.error("The current password does not match");
            throw new UnsafeNewPassword("The current password does not match");
        }
        if(oldPass.equals(newPass)){
            log.error("This password has been used recently!");
            throw new UnsafeNewPassword("This password has been used recently!");
        }
        User1.setPasswordUser(newPass);
        userRepository.save(User1);
        log.info("The pass was successfully change");
        return "The pass was successfully change";
    }

    public String deleteUser(Integer idUser){
        User user1 = userRepository.findById(idUser).orElseThrow(
                () -> new RuntimeException("User with this id is not found"));
        userRepository.delete(user1);
        log.info("The user was successfully delete");

        return "The user was successfully delete";
    }

    public List<Order> orderList(Integer idUser){
        User user1=  userRepository.findById(idUser).orElseThrow(() -> new RuntimeException("User with this id is not found"));
        return user1.getOrderList();
    }

}
