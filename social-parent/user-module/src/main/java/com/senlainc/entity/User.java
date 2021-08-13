package com.senlainc.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 7)
    private String gender;

    @Column(nullable = false)
    private String city;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "role_id")
    private Long roleId;

    public User() {
    }

    public User(String firstName, String lastName, String city, Long roleId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = "username";
        this.password = "123";
        this.email = "email";
        this.gender = "gender";
        this.city = "city";
        this.createdAt = LocalDateTime.now();
        this.roleId = roleId;
    }

    public User(String firstName, String lastName, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = "username";
        this.password = "123";
        this.email = "email";
        this.gender = "gender";
        this.city = "city";
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", createdAt=" + createdAt +
                ", roleId=" + roleId +
                '}';
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}