package com.fatiharge.resource;

import com.fatiharge.domain.Feedback;
import com.fatiharge.service.FeedbackService;
import com.fatiharge.shared.user.dto.feedback.FeedbackCreateDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/feedbacks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedbackResource {

    @Inject
    FeedbackService feedbackService;

    @POST
    public Feedback createFeedback(FeedbackCreateDTO feedbackCreateDTO) {
        return feedbackService.createFeedback(feedbackCreateDTO);
    }
}
