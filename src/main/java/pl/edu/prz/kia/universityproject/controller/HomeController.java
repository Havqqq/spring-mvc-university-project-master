package pl.edu.prz.kia.universityproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.edu.prz.kia.universityproject.model.Faculty;
import pl.edu.prz.kia.universityproject.model.Specialization;
import pl.edu.prz.kia.universityproject.service.FacultyService;
import pl.edu.prz.kia.universityproject.service.SpecializationService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    FacultyService facultyService;
    @Autowired
    SpecializationService specializationService;

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        List<Faculty> faculties = facultyService.findAll();
        List<Specialization> specializations = specializationService.findAll();
        modelAndView.addObject("faculties", faculties);
        modelAndView.addObject("specs", specializations);
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping(value = "activation")
    public ModelAndView activation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("activation");

        return modelAndView;
    }
}
