package com.example.OnlineShop.dto.customer;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class CustomerRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;


    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    private String firstNameCustomer;

    @NotNull(message = "Last name cannot be null")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastNameCustomer;

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    private String emailCustomer;

    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    private String usernameCustomer;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    private String passwordCustomer;


    @NotNull(message = "Address cannot be null")
    @NotEmpty(message = "Address name cannot be empty")
    private String addressCustomer;

    public CustomerRequest(int idCustomer, String firstNameCustomer, String lastNameCustomer, String emailCustomer, String usernameCustomer, String passwordCustomer, String addressCustomer) {
        this.idCustomer = idCustomer;
        this.firstNameCustomer = firstNameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.emailCustomer = emailCustomer;
        this.usernameCustomer = usernameCustomer;
        this.passwordCustomer = passwordCustomer;
        this.addressCustomer = addressCustomer;
    }

    public CustomerRequest() {
    }
}
