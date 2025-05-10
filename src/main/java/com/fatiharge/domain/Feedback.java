package com.fatiharge.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "feedback")
public class Feedback extends PanacheEntity {

    @NotNull
    @Size(min = 3, max = 100)
    @Column(name = "full_name")
    public String fullName;

    @NotNull
    @Email
    public String email;

    @NotNull
    @Size(max = 500)
    public String message;

    @NotNull
    @Min(1)
    @Max(5)
    public Double rating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    public Date createdDate;
}
