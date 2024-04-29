package co.newtonschool.splitwise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class HomeController {
    @GetMapping("")
    public ModelAndView viewHome() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home");

        return modelAndView;
    }
}
