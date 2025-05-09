package com.fatiharge.resource;

import com.fatiharge.domain.Feedback;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import jakarta.annotation.security.RolesAllowed;

@RolesAllowed({"admin"})
public interface AdminFeedbackResource extends PanacheEntityResource<Feedback, Long> {
}
