package com.olx.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.olx.entities.Roles;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String password;
    private String address;
    private Roles role;



}
