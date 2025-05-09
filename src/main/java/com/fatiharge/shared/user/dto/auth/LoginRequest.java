package com.fatiharge.shared.user.dto.auth;


import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Setter
public class LoginRequest {
    @NotBlank()
    @Schema(examples = "johnson_wood@example.com", required = true)
    public String mail;

    @NotBlank()
    @Schema(examples = "doow_123", required = true)
    public String password;
}