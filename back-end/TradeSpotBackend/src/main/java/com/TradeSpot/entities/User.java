package com.TradeSpot.entities;

import jakarta.persistence.*;
import com.TradeSpot.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends BaseEntity{


    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;
    @Column()
    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY , orphanRemoval = true, cascade = CascadeType.ALL)
    List<Product> products=new ArrayList<>();





}
