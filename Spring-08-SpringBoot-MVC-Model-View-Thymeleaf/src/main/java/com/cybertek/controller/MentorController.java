package com.cybertek.controller;

import com.cybertek.enums.Gender;
import com.cybertek.model.Mentor;
import com.sun.tools.javah.Gen;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {
    @GetMapping("/list")
    public String showTable(Model model){
        List<Mentor> mentorList=new ArrayList<>();
        mentorList.add(new Mentor(1, "Mike", "Smith", 45, Gender.MALE));
        mentorList.add(new Mentor(2, "Tom", "Hanks", 65, Gender.MALE));
        mentorList.add(new Mentor(3, "Ammy", "Bryan", 23, Gender.FEMALE));
        model.addAttribute("mentors", mentorList);
        return "/mentor/mentor-list";
    }
}
