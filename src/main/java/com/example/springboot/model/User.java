package com.example.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = false )
    @JoinColumn(name = "location_id")
    private Location location;
}
