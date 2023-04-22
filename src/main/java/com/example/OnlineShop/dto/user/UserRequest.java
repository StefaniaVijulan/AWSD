package com.example.OnlineShop.dto.user;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;


    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    private String firstNameUser;

    @NotNull(message = "Last name cannot be null")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastNameUser;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    private String emailUser;

    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    private String usernameUser;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    private String passwordUser;


    @NotNull(message = "Address cannot be null")
    @NotEmpty(message = "Address name cannot be empty")
    private String addressUser;

    public UserRequest(int idUser, String firstNameUser, String lastNameUser, String emailUser, String usernameUser, String passwordUser, String addressUser) {
        this.idUser = idUser;
        this.firstNameUser = firstNameUser;
        this.lastNameUser = lastNameUser;
        this.emailUser = emailUser;
        this.usernameUser = usernameUser;
        this.passwordUser = passwordUser;
        this.addressUser = addressUser;
    }

    public UserRequest() {
    }
}
