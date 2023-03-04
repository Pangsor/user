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

    /*
    @GetMapping("{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable("id") Long contactId){
        ContactDto movie = contactService.getContactById(contactId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ContactDto>> getAllContacts(){
        List<ContactDto> movieList = contactService.getAllContacts();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }
    */


    @DeleteMapping("{id}")
    public ResponseEntity<String> delDataUser(@PathVariable("id") int userid){
        userService.delDataUser(userid);
        return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }
}
