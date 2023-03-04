package com.walatech.userservice.controller;

import com.walatech.userservice.dto.UserDto;
import com.walatech.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createContact(@Valid @RequestBody UserDto userDto){
        UserDto savedMovie = userService.setDataUser(userDto);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<UserDto>> getDataUser(@PathVariable("id") String userid){
        List<UserDto> userDtoList = userService.getDataUser(userid);
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delDataUser(@PathVariable("id") int userid){
        userService.delDataUser(userid);
        return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }
}
