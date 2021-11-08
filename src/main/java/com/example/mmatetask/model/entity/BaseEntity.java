package com.example.mmatetask.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId () {
        return this.id;
    }

    public BaseEntity setId (Long id) {
        this.id = id;
        return this;
    }

    public BaseEntity () {
    }
}
