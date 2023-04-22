package com.example.OnlineShop.dto.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@Getter
@Setter
public class UserLogin{
    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    private String usernameUser;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    private String passwordUser;

    public UserLogin(String usernameUser, String passwordUser) {
        this.usernameUser = usernameUser;
        this.passwordUser = passwordUser;
    }

    public UserLogin() {
    }
}
