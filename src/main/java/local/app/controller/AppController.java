package local.app.controller;


import local.app.model.Feedback;
import local.app.repository.FeedbackRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private FeedbackRepositoryInterface feedbackRepositoryInterface;

    @GetMapping("/app")
    public String index(Model model) {
        model.addAttribute("feedbackList", feedbackRepositoryInterface.findAll());
        model.addAttribute("feedback", new Feedback());
        return "/index";
    }

    @PostMapping("/feedback/post")
    public String feedback(Feedback feedback) {
        feedbackRepositoryInterface.save(feedback);
        return "redirect:/app";
    }

    @PostMapping("/feedback/update")
    public String feedbackLike(Feedback feedback) {
        feedbackRepositoryInterface.save(feedback);
        return "redirect:/app";
    }
}
