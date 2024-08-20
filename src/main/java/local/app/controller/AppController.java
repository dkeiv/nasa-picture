package local.app.controller;


import local.app.model.Feedback;
import local.app.service.FeedbackServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {
    @Autowired
    private FeedbackServiceInterface feedbackService;

    @GetMapping("/app")
    public String index(Model model, @PageableDefault(size = 3) Pageable pageable) {
        model.addAttribute("feedbackList", feedbackService.findAll(pageable));
        model.addAttribute("feedback", new Feedback());
        return "/index";
    }

    @PostMapping("/feedback/post")
    public String feedback(@ModelAttribute("feedback") Feedback feedback) {
        feedbackService.save(feedback);
        return "redirect:/app";
    }

    @PostMapping("/feedback/{id}/like")
    public String feedbackLike(@ModelAttribute("feedback") Feedback feedback, RedirectAttributes redirectAttributes) {
        Feedback feedbackLiked = feedbackService.findById(feedback.getId());
        feedbackLiked.setLikes(feedbackLiked.getLikes() + 1);
        feedbackService.save(feedbackLiked);
        return "redirect:/app";
    }


}
