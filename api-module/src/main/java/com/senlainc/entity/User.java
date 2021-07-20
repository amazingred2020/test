package com.senlainc.entity;

import org.hibernate.annotations.GenerationTime;

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
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 7)
    private String gender;

    @Column(nullable = false)
    private String city;

    @Embedded
    private Account account;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private Set<User> friends = new HashSet<>();

    @Column(name = "created_at", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    @org.hibernate.annotations.Generated(GenerationTime.ALWAYS)
    private LocalDateTime updatedAt;


    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

     */

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
    }

    public User(String firstName, String lastName, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = "username";
        this.password = "123";
        this.email = "email";
        this.gender = "gender";
        this.city = "city";
    }

    public User(Long id, String firstName, String lastName, String city){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = "username";
        this.password = "123";
        this.email = "email";
        this.gender = "gender";
        this.city = "city";
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
                '}';
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Long getId(){
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Set<User> getFriends(){
        return friends;
    }

    public void addFriend(User user){
        getFriends().add(user);
    }

    public void deleteFriend(User user){
        getFriends().remove(user);
    }
}
