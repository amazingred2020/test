package com.senlainc.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "grants")
public class Grant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Grant(){
    }

    public Grant(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
