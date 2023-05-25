package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.entity.Feedback;
import rikkei.academy.model.service.FeedbackServiceIMPL;
import rikkei.academy.model.service.IFeedbackService;

@Controller
@RequestMapping({"/", "feedback"})
public class FeedbackController {
    IFeedbackService feedbackService = new FeedbackServiceIMPL();

    @GetMapping("/")
    public ModelAndView showFormFeedback() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("feedback", new Feedback());
        modelAndView.addObject("listFeedback", feedbackService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveFeedback(@ModelAttribute("feedback") Feedback feedback) {
        feedbackService.save(feedback);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("feedback", feedback);
        return modelAndView;
    }
}
