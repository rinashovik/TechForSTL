package com.SimpleTechNoLearning.TechForSTL.controllers;

import com.SimpleTechNoLearning.TechForSTL.data.UserProfileRepository;
import com.SimpleTechNoLearning.TechForSTL.models.UserProfile;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
    @RequestMapping(value="/user")

    public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping(value = "/")
    public String displayUserProfile(Model model) {
        model.addAttribute(new UserProfile());
        model.addAttribute("title", "adduser");
        return "add-user";

    }

    @PostMapping("/")
    public String processCreateUserProfileForm(@ModelAttribute @Valid UserProfile newUserProfile, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "adduser");

            return "add-user";
        } else {

            model.addAttribute("title", "Profile-List");

            userProfileRepository.save(newUserProfile);
            return "redirect:";


        }
    }

    @GetMapping("/list/{userId}")
    public String displayUserProfiler(Model model, @PathVariable int userId) {

//        if (userId !=null) {
        Optional<UserProfile> optUserProfile = userProfileRepository.findById(userId);
        if (optUserProfile.isPresent()) {
            UserProfile userProfile = (UserProfile) optUserProfile.get();
            model.addAttribute("userProfile", userProfile);

//            }
            return "profile-list";

        } else {

              model.addAttribute("userProfiles", userProfileRepository.findAll());

            return "redirect:/";

        }

    }

}