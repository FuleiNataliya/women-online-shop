package com.women.online.shop.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class AbstractEntity {
    @Id
    @Column(updatable = false)
    private String id;
    @Column(updatable = false)
    private LocalDateTime createdAt;

    public AbstractEntity() {
        this.setId(UUID.randomUUID().toString());
        this.setCreatedAt(LocalDateTime.now());
    }
}