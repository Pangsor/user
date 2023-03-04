package com.walatech.userservice.service.impl;

import com.walatech.userservice.dto.UserDto;
import com.walatech.userservice.entity.User;
import com.walatech.userservice.exception.ResourceNotFoundException;
import com.walatech.userservice.exception.UsernameAlreadyExistException;
import com.walatech.userservice.repository.UserRepository;
import com.walatech.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto setDataUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());

        if(optionalUser.isPresent()){
            throw new UsernameAlreadyExistException("Username Already Exists for User");
        }
        User user = modelMapper.map(userDto,User.class);
        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto getDataUser(Long contactId) {
        return null;
    }

    @Override
    public void delDataUser(int userId) {
        userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","id",userId)
        );
        userRepository.deleteById(userId);
    }
}
