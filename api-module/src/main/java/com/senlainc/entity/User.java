package com.senlainc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    private String gender;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String city;

    @JsonIgnore
    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<User> friends = new HashSet<>();

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(String firstName, String lastName, String gender, String city, String email, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.city = city;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", role=" + role +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public Long getId(){
        return id;
    }

    public Set<User> getFriends(){
        return friends;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    /*
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    */

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getUsername() {
        return username;
    }

    public void addFriend(User user){
        getFriends().add(user);
    }

    public void deleteFriend(User user){
        getFriends().remove(user);
    }

    public void setRole(Role roleById) {
        this.role = role;
    }
}
