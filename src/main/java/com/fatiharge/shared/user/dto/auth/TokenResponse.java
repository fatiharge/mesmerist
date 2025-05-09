package com.fatiharge.shared.user.dto.auth;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Builder
public class TokenResponse {
    @NotBlank()
    @Schema(examples = "U2VsYW0gYnUgc2FkZWNlIHRlc3QgdG9rZW5pIGx1dGZlbiBnZXJjZWsgdG9rZW5pIGFsLiA6KQ==", required = true)
    public String token;

    @Schema(examples = "U2VsYW0gYnUgc2FkZWNlIHRlc3QgdG9rZW5pIGx1dGZlbiBnZXJjZWsgdG9rZW5pIGFsLiA6KQ==", required = true)
    public String refreshToken;
}