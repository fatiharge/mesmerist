package com.fatiharge.resource;

import com.fatiharge.domain.Menu;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import jakarta.annotation.security.RolesAllowed;


@RolesAllowed({"admin"})
public interface AdminMenuResource extends PanacheEntityResource<Menu, Long> {}

