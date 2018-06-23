package pl.edu.prz.kia.universityproject.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.prz.kia.universityproject.model.Question;
import pl.edu.prz.kia.universityproject.model.User;
import pl.edu.prz.kia.universityproject.model.UserAnswer;
import pl.edu.prz.kia.universityproject.model.UserAnswersWrapper;
import pl.edu.prz.kia.universityproject.service.QuestionService;
import pl.edu.prz.kia.universityproject.service.SpecializationService;
import pl.edu.prz.kia.universityproject.service.UserAnswerService;
import pl.edu.prz.kia.universityproject.service.UserService;

import java.util.List;
import java.util.logging.Logger;


@Controller
public class UserController {

    private UserService userService;
    private UserAnswerService userAnswerService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private SpecializationService specializationService;

    @Autowired
    public UserController(UserService userService, UserAnswerService userAnswerService) {
        this.userService = userService;
        this.userAnswerService = userAnswerService;
    }

    @GetMapping(value = "/user/home")
    public ModelAndView userHome() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user/home");
        return modelAndView;
    }

    @PostMapping(path="/user/survey")
    public String surveyUpdate(@ModelAttribute("wrapper") UserAnswersWrapper wrapper) {
        wrapper.getAnswerList().forEach(userAnswer -> userAnswerService.update(userAnswer));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        userService.calculateSurveyResults(specializationService.findAll(), user);
        return "redirect:home";
    }


    @GetMapping(value = "/user/survey")
    public ModelAndView userSurvey() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("user", user);

        //-------

        UserAnswersWrapper wrapper = new UserAnswersWrapper(userAnswerService.findByUser(user));
        modelAndView.addObject("wrapper", wrapper);

        // -------

        List<UserAnswer> userAnswers = userAnswerService.findByUser(user);
        modelAndView.addObject("userAnswers", userAnswers);

        // -------

        List<Question> questions = questionService.findAll();
        modelAndView.addObject("questions", questions);

        // -------

        modelAndView.setViewName("user/survey");
        return modelAndView;
    }


    @RequestMapping(value = "/activation/{user_id}", method = RequestMethod.GET)

    public String handleUserActivation(@PathVariable String user_id) {
        //System.out.println(user_id);
        System.out.println("test");
        long idd = Long.parseLong(user_id);
        User user = userService.getOne(idd);
        userService.saveUserActivation(user);

        return "redirect:/activation";
    }
}
