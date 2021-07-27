package com.senlainc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.senlainc.jpaconfig.CustomLocalDateTimeSerializer;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> child = new ArrayList<>();

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Comment(){
    }

    public Comment(String content){
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setAuthor(User user){
        this.user = user;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
