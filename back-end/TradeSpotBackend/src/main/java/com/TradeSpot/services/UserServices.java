package com.olx.services;

import com.olx.DTO.UserDTO;
import com.olx.entities.User;
import com.olx.repositories.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public User addUser(UserDTO userDTO) {

        User user= mapper.map(userDTO, User.class);
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
}
