package com.fatiharge.shared.user.dto.user;

import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


public class UserResponse {
    @NotBlank()
    public Long id;
    @Schema(examples = "johnson_wood@example.com", required = true)
    public String mail;
    @Schema(examples = "Johnson", required = true)
    public String name;
    @Schema(examples = "Wood", required = true)
    public String surname;
}


