
package com.TradeSpot.services;


import com.TradeSpot.DTO.UserDTO;
import com.TradeSpot.DTO.UserRespDTO;
import com.TradeSpot.customException.CustomException;
import com.TradeSpot.entities.Roles;
import com.TradeSpot.entities.User;
import com.TradeSpot.repositories.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServices {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    public User addUser(UserDTO userDTO) {

        if(userRepo.existsByEmail(userDTO.getEmail())){
            return null;
        }
        User user= mapper.map(userDTO, User.class);

        //hash the password
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setRole(Roles.BUYER);
        return userRepo.save(user);
    }

    public List<UserDTO> listOfAllUsers() {

        List<User> users=userRepo.findAll();
        return users.stream().map(user-> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    public UserDTO findUser(Long id) {

        User user=userRepo.findById(id).orElseThrow();
        return mapper.map(user, UserDTO.class);
    }

    public void deleteUser(Long id) {

        userRepo.deleteById(id);
    }

    public List<User> findByName(String name) {

        return userRepo.getByName(name);
    }

    public UserRespDTO findByEmail(String email){
        User user=userRepo.findByEmail(email).orElseThrow(()->new CustomException("User with email not exits"));
        return  mapper.map(user, UserRespDTO.class) ;
    }


}
