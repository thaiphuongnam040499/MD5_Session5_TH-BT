package rikkei.academy.model.service;

import rikkei.academy.model.entity.Feedback;

import java.util.List;

public interface IFeedbackService {
    List<Feedback> findAll();

    Feedback findById(Long id);

    void deleteById(Long id);

    void save(Feedback feedback);
}
