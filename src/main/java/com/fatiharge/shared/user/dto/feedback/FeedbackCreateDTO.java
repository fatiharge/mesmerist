package com.fatiharge.shared.user.dto.feedback;

import jakarta.validation.constraints.*;

public class FeedbackCreateDTO {

    @NotNull
    @Size(min = 3, max = 100)
    public String fullName;

    @NotNull
    @Email
    public String email;

    @NotNull
    @Size(max = 500)
    public String message;

    @NotNull
    @Min(1)
    @Max(5)
    public Double rating;
}
