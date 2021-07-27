package com.senlainc.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;
import org.hibernate.annotations.GenerationTime;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /*@ElementCollection
    @CollectionTable(name = "product_image")
    @AttributeOverride(name = "name", column = @Column(name = "filename", nullable = false))
    private Set<Image> images = new HashSet<Image>();
*/
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Product(){
    }

    public Product(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public User getSeller() {
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}