package com.senlainc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "roles_grants",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "grant_id"))
    private Set<Grant> grants = new HashSet<>();

    public Role(){
    }

    public Role(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Set<Grant> getGrants() {
        return grants;
    }

    public void addGrant(Grant grant){
        getGrants().add(grant);
    }

    public void removeGrant(Grant grant){
        getGrants().remove(grant);
    }
}

