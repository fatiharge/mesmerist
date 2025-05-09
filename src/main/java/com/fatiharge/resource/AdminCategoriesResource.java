package com.fatiharge.resource;

import com.fatiharge.domain.Categories;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import jakarta.annotation.security.RolesAllowed;

@RolesAllowed({"admin"})
public interface AdminCategoriesResource extends PanacheEntityResource<Categories, Long> {
}
