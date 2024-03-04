package com.SimpleTechNoLearning.TechForSTL.controllers;

import com.SimpleTechNoLearning.TechForSTL.data.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/profile")
public class HomeController {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping(value="/")
    public String displayProfileDetails(Model model){

        model.addAttribute("title", "List");
        model.addAttribute("userProfiles", userProfileRepository.findAll());

        return "user-profile";
    }


}
