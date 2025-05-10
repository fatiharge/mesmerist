package com.fatiharge.repository;


import com.fatiharge.domain.Feedback;
import com.fatiharge.shared.user.dto.feedback.FeedbackCreateDTO;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FeedbackRepository implements PanacheRepository<Feedback> {

    @Transactional
    public Feedback createFeedback(FeedbackCreateDTO feedbackDto) {
        Feedback feedback = new Feedback();
        feedback.fullName = feedbackDto.fullName;
        feedback.email = feedbackDto.email;
        feedback.message = feedbackDto.message;
        feedback.rating = feedbackDto.rating;
        persist(feedback);
        return feedback;
    }
}
