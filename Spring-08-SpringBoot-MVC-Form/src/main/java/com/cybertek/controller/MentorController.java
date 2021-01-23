package com.cybertek.controller;

import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register")
    public String showForm(Model model) {

        model.addAttribute("mentor", new Mentor()); //bind mentor object
        List<String> batchList = Arrays.asList("Select ...", "B6", "B7", "B8", "B9", "B10", "B11", "B12");
        model.addAttribute("batchlist", batchList);

        return "/mentor/mentor-register"; //return to html page 'mentor-register' html file
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor) {
        System.out.println(mentor.toString());
        return "/mentor/mentor-confirmation";
    }

}
