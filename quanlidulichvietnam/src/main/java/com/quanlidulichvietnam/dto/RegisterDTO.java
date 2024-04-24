/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quanlidulichvietnam.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO implements Serializable {

    @NotEmpty(message = "The username is required")
    private String username;

    @NotEmpty(message = "The password is required")
    private String password;

    @NotEmpty(message = "The fullname is required")
    private String fullName;

    @Email(message = "The email is required")
    private String email;

    @NotEmpty(message = "The phone is required")
    private String phone;

    @NotEmpty(message = "The address is required")
    private String address;

    @NotEmpty
    private Date dob;

    @NotEmpty
    private byte gender;

}
