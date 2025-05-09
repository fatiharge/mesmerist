package com.fatiharge.shared.user.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Setter
public class CreateUserRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    @Schema(examples = "johnson_wood@example.com", required = true)
    public String mail;

    @NotBlank
    @Schema(examples = "doow_123", required = true)
    public String password;

    @NotBlank
    @Schema(examples = "Johnson", required = true)
    public String name;


    @Schema(examples = "Wood", required = true)
    public String surname;

}

