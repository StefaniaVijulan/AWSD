package com.example.OnlineShop.dto.user;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class UserResponse {

    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    private String firstNameUser;

    @NotNull(message = "Last name cannot be null")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastNameUser;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    private String emailUser;
    private String jwt;

    public UserResponse(String firstNameUser, String lastNameUser, String emailUser) {
        this.firstNameUser = firstNameUser;
        this.lastNameUser = lastNameUser;
        this.emailUser = emailUser;
    }

    public UserResponse() {
    }
}
