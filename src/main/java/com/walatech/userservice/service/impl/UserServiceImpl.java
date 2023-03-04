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

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto setDataUser(UserDto userDto) {
        if (userDto.getUserid() > 0) {
            User existingUser = userRepository.findById(userDto.getUserid()).orElseThrow(
                    () -> new ResourceNotFoundException("User", "userid", userDto.getUserid())
            );
            existingUser.setNamalengkap(userDto.getNamalengkap());
            existingUser.setUsername(userDto.getUsername());
            existingUser.setPassword(userDto.getPassword());
            existingUser.setStatus(userDto.getStatus());
            User updatedUser = userRepository.save(existingUser);
            return modelMapper.map(updatedUser, UserDto.class);
        }else {
            Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());
            if (optionalUser.isPresent()) {
                throw new UsernameAlreadyExistException("Username Already Exists for User");
            }
            User user = modelMapper.map(userDto, User.class);
            User savedUser = userRepository.save(user);
            return modelMapper.map(savedUser, UserDto.class);
        }
    }

    @Override
    public List<UserDto> getDataUser(String userId) {
        if(userId.equalsIgnoreCase("all")) {
            List<User> userList = userRepository.findAll();
            return userList.stream().map((user) -> modelMapper.map(user, UserDto.class))
                    .collect(Collectors.toList());
        }else {

            User user = userRepository.findById(Integer.parseInt(userId)).orElseThrow(
                    () -> new ResourceNotFoundException("User","userid",Integer.parseInt(userId))
            );
            return Collections.singletonList(modelMapper.map(user, UserDto.class));
        }
    }

    @Override
    public void delDataUser(int userId) {
        userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User","userid",userId)
        );
        userRepository.deleteById(userId);
    }
}
