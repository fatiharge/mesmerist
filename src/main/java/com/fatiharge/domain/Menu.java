package com.fatiharge.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "menu")

public class Menu extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    public Categories category;

    @NotNull
    @Column(name = "cooking_time_minutes", nullable = false)
    public Integer cookingTimeMinutes;

    @NotNull
    @Column(name = "serving_size", nullable = false)
    public String servingSize;

    @NotNull
    @Column(name = "calories", nullable = false)
    public Integer calories;

    @NotNull
    @Column(name = "ingredients", nullable = false)
    public String ingredients;

    @NotNull
    @Column()
    public String imagePath;

    @NotNull
    @Column(unique = true)
    public String name;

    @NotNull
    @Column(name = "preparation", nullable = false)
    public String preparation;

    @NotNull
    @Column(name = "daily")
    public Boolean daily = false;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    public Date createdDate;
}



