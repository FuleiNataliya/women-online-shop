package com.women.online.shop.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    private String id;
    private LocalDateTime createdAt;

    public AbstractEntity() {
        this.setId(UUID.randomUUID().toString());
        this.setCreatedAt(LocalDateTime.now());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
