package com.SimpleTechNoLearning.TechForSTL.controllers;

import com.SimpleTechNoLearning.TechForSTL.data.UserProfileRepository;
import com.SimpleTechNoLearning.TechForSTL.models.UserProfile;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/profile")
public class UserProfileController {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping(value="/")
    public String displayProfileDetails(Model model){

        model.addAttribute("title", "User Profile");
        model.addAttribute("userProfiles", userProfileRepository.findAll());

        return "userProfile/index";
    }

    @GetMapping(value = "/addUser")
    public String displayCreateNewUserProfileForm(Model model) {
        model.addAttribute(new UserProfile());
        model.addAttribute("title", "Add User");
        return "userProfile/add-user";

    }

    @PostMapping("/addUser")
    public String processCreateNewUserProfileForm(@ModelAttribute @Valid UserProfile newUserProfile, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");

            return "userProfile/add-user";
        } else {

            model.addAttribute("title", "Profile-List");
            userProfileRepository.save(newUserProfile);
            return "redirect:/profile/";
            // return "profile-list";

            // return "redirect:/addUser/";


        }
    }

    @GetMapping("/edit/{userId}")

    public String displayUserProfiler(Model model, @PathVariable int userId) {

//        if (userId !=null) {
        Optional<UserProfile> optUserProfile = userProfileRepository.findById(userId);
        if (optUserProfile.isPresent()) {
            UserProfile userProfile = (UserProfile) optUserProfile.get();
            model.addAttribute("userProfile", userProfile);

//            }

            return "useProfile/edit";

        } else {

            model.addAttribute("userProfiles", userProfileRepository.findAll());

            return "redirect:/";

        }

    }


    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable List<Integer> userIds, Model model) {
        List<UserProfile> optUserProfile = (List<UserProfile>) userProfileRepository.findAll();
//        .orElseThrow(() - > new IllegalArgumentException("Invalid Task Id:" + taskId));
        model.addAttribute("userProfile", optUserProfile);
        return "update-user";
    }



    @GetMapping("/")
    public String renderDeleteTaskForm(Model model) {
        model.addAttribute("userProfiles", userProfileRepository.findAll());
        return "user-profile";
    }

    @PostMapping("/")
    public String processDeleteTaskForm(@RequestParam(required = false) int[] userId) {
        for (int id : userId) {
            userProfileRepository.deleteById(id);
        }
        return "redirect:/";
    }



}
