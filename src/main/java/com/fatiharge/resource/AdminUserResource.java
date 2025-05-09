package com.fatiharge.resource;

import com.fatiharge.domain.User;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import jakarta.annotation.security.RolesAllowed;

@RolesAllowed({"admin"})
public interface AdminUserResource extends PanacheEntityResource< User, Long> {
}
