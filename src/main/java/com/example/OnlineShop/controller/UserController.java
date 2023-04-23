package com.example.OnlineShop.controller;


import com.example.OnlineShop.config.JwtUtil;
import com.example.OnlineShop.dto.user.UserLogin;
import com.example.OnlineShop.dto.user.UserRequest;
import com.example.OnlineShop.dto.user.UserResponse;
import com.example.OnlineShop.model.Order;
import com.example.OnlineShop.model.User;
import com.example.OnlineShop.service.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;
    private final UserServiceInt userServiceInt;

    public UserController(UserServiceInt userServiceInt) {
        this.userServiceInt = userServiceInt;
    }
  ;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLogin userLogin) throws Exception {
        //    excelReadService.ReadDataFromExcel("src/main/resources/excelFile/UserDB.xlsx");

        try {
            System.out.println("Ajungem aici 1");
            System.out.println(userLogin.getUsernameUser());
            System.out.println(userLogin.getPasswordUser());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLogin.getUsernameUser(),
                            userLogin.getPasswordUser()));
        }
        catch (BadCredentialsException e) {
            System.out.println("Ajungem aici 2");

            return null;
        }
        System.out.println("Ajungem aici 3");
        final UserDetails userDetails = userServiceInt
                .loadUserByUsername(userLogin.getUsernameUser());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        User currentUser = userServiceInt.loginUser(userLogin.getUsernameUser(), userLogin.getPasswordUser());
        UserResponse userResponse = new UserResponse();
        userResponse.setJwt(jwt);
        userResponse.setEmailUser(currentUser.getEmailUser());
        userResponse.setFirstNameUser(currentUser.getFirstNameUser());
        userResponse.setLastNameUser(currentUser.getLastNameUser());
        return ResponseEntity.ok(userResponse);
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid UserRequest user) throws Exception {

        System.out.println("Ajungem aici");
        userServiceInt.registerUser(user);
        return "done";
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
