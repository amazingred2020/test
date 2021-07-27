package com.senlainc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "users_groups",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private User user;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Group(){
    }

    public Group(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Set<User> getUsers(){
        return users;
    }

    public void setAdmin(User user){
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addUserToGroup(User user){
        getUsers().add(user);
    }

    public void removeUserFromGroup(User user){
        getUsers().remove(user);
    }
}
