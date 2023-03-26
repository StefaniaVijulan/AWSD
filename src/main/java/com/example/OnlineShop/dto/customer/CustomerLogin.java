package com.example.OnlineShop.dto.customer;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Getter
@Setter
public class CustomerLogin {
    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    private String usernameCustomer;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    private String passwordCustomer;

    public CustomerLogin(String usernameCustomer, String passwordCustomer) {
        this.usernameCustomer = usernameCustomer;
        this.passwordCustomer = passwordCustomer;
    }

    public CustomerLogin() {
    }
}
