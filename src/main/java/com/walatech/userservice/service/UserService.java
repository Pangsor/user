package com.walatech.userservice.service;

import com.walatech.userservice.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto setDataUser(UserDto userDto);
    List<UserDto> getDataUser(String userId);
    void delDataUser(int userId);
}
