
package com.TradeSpot.entities;

import jakarta.persistence.*;
import com.TradeSpot.entities.*;


import java.util.ArrayList;
import java.util.List;

import lombok.*;


@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity{


    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "buyer",cascade = CascadeType.ALL)
    List<BroughtItems> broughtItemsList=new ArrayList<>();

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    List<SellItems> sellItemsList=new ArrayList<>();


}
