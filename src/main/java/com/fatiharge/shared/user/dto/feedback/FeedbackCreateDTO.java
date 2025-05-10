package com.fatiharge.shared.user.dto.feedback;

import jakarta.validation.constraints.*;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Setter
public class FeedbackCreateDTO {

    @NotBlank()
    @Size(min = 3, max = 100)
    public String fullName;

    @NotBlank()
    @Schema(examples = "johnson_wood@example.com", required = true)
    public String email;

    @NotBlank()
    @Size(max = 500)
    public String message;

    @NotBlank()
    @Min(1)
    @Max(5)
    public Double rating;
}
