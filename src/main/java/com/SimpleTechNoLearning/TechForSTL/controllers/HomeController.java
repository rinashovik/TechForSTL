
package com.SimpleTechNoLearning.TechForSTL.controllers;

import com.SimpleTechNoLearning.TechForSTL.data.UserProfileRepository;
import com.SimpleTechNoLearning.TechForSTL.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @Controller
    @RequestMapping(value="/")

    public class HomeController {

    @Autowired
    private UserProfileRepository userProfileRepository;



        @GetMapping(value="/")
        public String getHomePage(){
            return "home";

        }

        @GetMapping(value="/index")
        public String getLandingPage(){
            return "index";

        }

        @GetMapping(value="/contact")
        public String getContactPage(){
            return "contact";

        }

        @GetMapping(value="/settings")
        public String getSettingsPage(){
            return "settings";

        }


//    @GetMapping(value = "/")
//    public String displayCreateNewUserProfileForm(Model model) {
//        model.addAttribute(new UserProfile());
//        model.addAttribute("title", "Add User");
//        return "user/add-user";
//
//    }
//
//    @PostMapping("/")
//    public String processCreateNewUserProfileForm(@ModelAttribute @Valid UserProfile newUserProfile, Errors errors, Model model) {
//
//        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add User");
//
//            return "user/add-user";
//        } else {
//
//            model.addAttribute("title", "Profile-List");
//            userProfileRepository.save(newUserProfile);
//            return "redirect:/profile/";
//           // return "profile-list";
//
//             // return "redirect:/addUser/";
//
//
//        }
//    }

   // @GetMapping("/edit/{userId}")
//    @GetMapping("/edit/{userId}")
//
//    public String displayUserProfiler(Model model, @PathVariable int userId) {
//
////        if (userId !=null) {
//        Optional<UserProfile> optUserProfile = userProfileRepository.findById(userId);
//        if (optUserProfile.isPresent()) {
//            UserProfile userProfile = (UserProfile) optUserProfile.get();
//            model.addAttribute("userProfile", userProfile);
//
////            }
//            return "profile-list";
//
//        } else {
//
//              model.addAttribute("userProfiles", userProfileRepository.findAll());
//
//            return "redirect:/";
//
//        }
//
//    }
//
//
//    @GetMapping("edit/{id}")
//    public String showUpdateForm(@PathVariable List<Integer> userIds, Model model) {
//        List<UserProfile> optUserProfile = (List<UserProfile>) userProfileRepository.findAll();
////        .orElseThrow(() - > new IllegalArgumentException("Invalid Task Id:" + taskId));
//        model.addAttribute("userProfile", optUserProfile);
//        return "update-user";
//    }


    @GetMapping("/delete")
    public String renderDeleteTaskForm(Model model) {
        model.addAttribute("userProfiles", userProfileRepository.findAll());
        return "delete-user";
    }

    @PostMapping("/delete")
    public String processDeleteTaskForm(@RequestParam(required = false) int[] userId) {
        for (int id : userId) {
            userProfileRepository.deleteById(id);
        }
        return "redirect:/";
    }


}