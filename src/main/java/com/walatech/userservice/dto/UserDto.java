package com.walatech.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int userid;

    @NotEmpty(message = "Full name should not be null or empty")
    private String namalengkap;

    @NotEmpty(message = "Username should not be null or empty")
    private String username;

    @NotEmpty(message = "Password should not be null or empty")
    private String password;

    @NotEmpty(message = "Status should not be null or empty")
    private String status;
}
