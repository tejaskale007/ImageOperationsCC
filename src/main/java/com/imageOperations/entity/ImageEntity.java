package com.imageOperations.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "image")
@Getter
@Setter
public class ImageEntity {
    @Id
    @Column(name = "id")
    private Long id;

    private String imageName;

    private byte[] imageData;
}
