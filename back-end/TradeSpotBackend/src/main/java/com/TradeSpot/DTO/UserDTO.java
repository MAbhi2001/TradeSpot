
package com.TradeSpot.DTO;

import com.TradeSpot.entities.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;




import com.fasterxml.jackson.annotation.JsonIgnore;


import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty( access=JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String address;
    private Roles role;



}
