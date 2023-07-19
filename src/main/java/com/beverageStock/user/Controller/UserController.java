package com.beverageStock.user.Controller;

import com.beverageStock.user.DTO.UserDTO;
import com.beverageStock.user.Model.User;
import com.beverageStock.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user")
    public ResponseEntity<List<UserDTO>> getUser(){
       return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("user/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO),HttpStatus.CREATED);
    }

    @PutMapping("user/{userId}/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("userId") int userId){
        UserDTO response = userService.updateUser(userDTO,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("user/{userId}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted Successfully",HttpStatus.OK);
    }

}
