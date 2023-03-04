package com.walatech.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int userid;

    @NotEmpty(message = "Full name should not be null or empty")
    @Size(min = 1,max = 100)
    private String namalengkap;

    @NotEmpty(message = "Username should not be null or empty")
    @Size(min = 1,max = 100)
    private String username;

    @NotEmpty(message = "Password should not be null or empty")
    @Size(min = 1,max = 100)
    private String password;

    @NotEmpty(message = "Status should not be null or empty")
    @Size(min = 1,max = 1)
    private String status;
}
