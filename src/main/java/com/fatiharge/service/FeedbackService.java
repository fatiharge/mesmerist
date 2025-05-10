package com.fatiharge.service;

import com.fatiharge.domain.Feedback;
import com.fatiharge.repository.FeedbackRepository;
import com.fatiharge.shared.user.dto.feedback.FeedbackCreateDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FeedbackService {
    @Inject
    FeedbackRepository feedbackRepository;
    @Transactional
    public Feedback createFeedback(FeedbackCreateDTO feedbackCreateDTO) {
        return feedbackRepository.createFeedback(feedbackCreateDTO);
    }
}

