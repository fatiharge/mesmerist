package com.fatiharge.user.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "users")
@UserDefinition

public class User extends PanacheEntity {
    @Username
    @NotNull
    @Column(unique = true)
    public String mail;

    @NotNull
    @Password
    public String password;

    @Roles
    public String role;

    public String surname;

    @NotNull
    public String name;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    public Date createdDate;


}

