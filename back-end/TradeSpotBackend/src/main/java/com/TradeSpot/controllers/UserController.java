package com.TradeSpot.controllers;



import com.TradeSpot.DTO.UserDTO;
import com.TradeSpot.entities.User;

import com.TradeSpot.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserServices userservice;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO){
        User user=userservice.addUser(userDTO);

        if(user!= null){
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users= userservice.listOfAllUsers();

        if(users!= null){
            return ResponseEntity.ok(users);
        }
        else{
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(path ="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserDTO> getByIdUser(@PathVariable Long id){
        UserDTO user= userservice.findUser(id);

        if(user!= null){
            return ResponseEntity.ok(user);
        }
        else{
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){

        userservice.deleteUser(id);
        return ResponseEntity.ok().build();


    }

    @GetMapping("/byname/{name}")
    public List<User> getByName(@PathVariable String name){
        return userservice.findByName(name);
    }
}
