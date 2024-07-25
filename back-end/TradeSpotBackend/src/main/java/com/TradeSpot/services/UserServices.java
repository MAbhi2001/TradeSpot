
package com.TradeSpot.services;


import com.TradeSpot.DTO.UserDTO;
import com.TradeSpot.entities.Roles;
import com.TradeSpot.entities.User;
import com.TradeSpot.repositories.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    public User addUser(UserDTO userDTO) {

        if(userRepository.existsByEmail(userDTO.getEmail())){
            return null;
        }
        User user= mapper.map(userDTO, User.class);

        //hash the password
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setRole(Roles.valueOf(userDTO.getRole()));
        return userRepository.save(user);
    }

    public List<UserDTO> listOfAllUsers() {

        List<User> users= userRepository.findAll();
        return users.stream().map(user-> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    public UserDTO findUser(Long id) {

        User user= userRepository.findById(id).orElseThrow();
        return mapper.map(user, UserDTO.class);
    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

    public List<User> findByName(String name) {

        return userRepository.getByName(name);
    }


}
