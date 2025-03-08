package com.example.userservice.controller;


import com.example.userservice.customstatus.ErrorStatus;
import com.example.userservice.customstatus.SuccessStatus;
import com.example.userservice.dto.CustomStatus;
import com.example.userservice.dto.impl.UserDTO;
import com.example.userservice.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomStatus saveUser(@RequestBody UserDTO userDTO){
        if (userDTO == null){
            return new ErrorStatus(204, "Error saving user");
        }

        userService.save(userDTO);
        return new SuccessStatus(201,"user saved successfully!");
    }

    @PutMapping(value = "/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomStatus updateUser(@RequestBody UserDTO userDTO,@PathVariable Long userId){
        if (userDTO == null){
            return new ErrorStatus(204, "Error update user");
        }

        userService.update(userId,userDTO);
        return new SuccessStatus(201,"user update successfully!");
    }

    @GetMapping(value = "/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser(@PathVariable Long userId){
        return userService.get(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping(value = "/{userId}")
    public CustomStatus deleteUser(@PathVariable Long userId){
        if (userId == null){
            return new ErrorStatus(204, "Error delete user");
        }

        userService.delete(userId);
        return new SuccessStatus(200, "Success delete user");
    }



}
