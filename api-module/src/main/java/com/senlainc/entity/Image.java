package com.senlainc.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode
public class Image {

    @Column(nullable = false)
    private String name;

    private byte[] content;
}
