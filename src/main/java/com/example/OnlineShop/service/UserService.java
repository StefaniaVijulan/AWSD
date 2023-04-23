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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class UserService implements UserServiceInt, UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        UserDetails user = userRepository.findUserByUsernameUser(username);

        if(user == null){
            user = userRepository.findUserByUsernameUser(username);
        }
        if(user == null){
            throw new UsernameNotFoundException(
                    String.format("username %s not found", username));
        }

        return user;
    }
    public User loginUser(String username, String password){
        if (!userRepository.existsByUsernameUser(username)) {
            throw new IllegalStateException("Cnp doesn't exist");
        }

        User userProfile = userRepository.findUserByUsernameUser(username);
        String pass = userProfile.getPassword();
        if (!bCryptPasswordEncoder.matches(password, pass)) {
            throw new IllegalStateException("Cnp doesnt exist");

        }
        System.out.println(userProfile);
        return userProfile;
    }
    public UserResponse registerUser(UserRequest User) {
        System.out.println("here");
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
        user1.setPasswordUser(bCryptPasswordEncoder.encode(User.getPasswordUser()));
        user1.setAddressUser(User.getAddressUser());
        if(User.getRoleUser().equals("")){
            user1.setRoleUser("client");
        }else{
            user1.setRoleUser(User.getRoleUser());
        }
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
