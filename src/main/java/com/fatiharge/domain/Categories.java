package com.fatiharge.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "categories")

public class Categories extends PanacheEntity {
    @NotNull
    @Column(unique = true)
    public String name;

    @NotNull
    @Column(unique = true)
    public String iconPath;

    @NotNull
    @Column(unique = true)
    public String imagePath;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    public Date createdDate;
}


