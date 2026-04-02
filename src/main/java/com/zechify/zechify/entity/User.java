package com.zechify.zechify.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "users")
@Data
public class User {
    @Id @GeneratedValue
    private Long id;


    private String username;
    private String passwordHash;



}
