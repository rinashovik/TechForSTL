//package com.SimpleTechNoLearning.TechForSTL.controllers;
//
//
//import com.SimpleTechNoLearning.TechForSTL.data.UserRepository;
//import com.SimpleTechNoLearning.TechForSTL.models.User;
//import com.SimpleTechNoLearning.TechForSTL.models.dto.LoginFormDTO;
//import com.SimpleTechNoLearning.TechForSTL.models.dto.RegisterFormDTO;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collections;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/")
//public class AuthenticationController {
//    @Autowired
//    private UserRepository userRepository;
//    private static final String userSessionKey = "user";
//
//    @GetMapping("/")
//    @ResponseBody
//    public String hello(){
//
//        return "Hello Viewers";
//    }
////
////    public User getUserFromSession(HttpSession session) {
////        Integer userId = (Integer) session.getAttribute(userSessionKey);
////        if (userId == null) {
////            return null;
////        }
////
////        Optional<User> user = userRepository.findById(userId);
////
////        if (user.isEmpty()) {
////            return null;
////        }
////
////        return user.get();
////    }
////
////    private static void setUserInSession(HttpSession session, User user) {
////        session.setAttribute(userSessionKey, user.getId());
////    }
////
////
////    @GetMapping("/register")
////    public String displayRegistrationForm(Model model) {
////        model.addAttribute(new RegisterFormDTO());
////        model.addAttribute("title", "Register");
////        return "register";
////    }
////
////    @PostMapping("/register")
////    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
////                                          Errors errors, HttpServletRequest request,
////                                          Model model) {
////
////        if (errors.hasErrors()) {
////            model.addAttribute("title", "Register");
////            return "register";
////        }
////
////        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());
//////        User existingUserByEmail = userRepository.findByEmail(registerFormDTO.getEmail());
//////        User existingUserByVerifyPassword = userRepository.findByEmail(registerFormDTO.getVerifyPassword());
////
////        if (existingUser != null) {
////            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
////            model.addAttribute("title", "Register");
//////            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "User with the given username already exists"));
////
////            return "register";
////        }
////
//////        if (existingUserByEmail != null) {
//////            errors.rejectValue("email", "email.alreadyexists", "That email already exists, try a different one.");
//////            model.addAttribute("title", "Register");
////////            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "User with the given email already exists"));
//////            return "register";
//////
//////        }
////
////        String password = registerFormDTO.getPassword();
////        String verifyPassword = registerFormDTO.getVerifyPassword();
////        if (!password.equals(verifyPassword)) {
////            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
////            model.addAttribute("title", "Register");
//////            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Passwords do not match"));
////
////            return "register";
////        }
////
//////        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getEmail(),registerFormDTO.getPassword(),registerFormDTO.getVerifyPassword());
////        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
////        userRepository.save(newUser);
////        setUserInSession(request.getSession(), newUser);
////
////        return "redirect:";
////    }
////
////    @GetMapping("/login")
////    public String displayLoginForm(Model model) {
////        model.addAttribute(new LoginFormDTO());
////        model.addAttribute("title", "Log In");
////        return "login";
////    }
////
////
////    @PostMapping("/login")
////    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
////                                   Errors errors, HttpServletRequest request,
////                                   Model model) {
////
////        if (errors.hasErrors()) {
////            model.addAttribute("title", "Log In");
////            return "login";
////        }
////
////        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());
////
////        if (theUser == null) {
////            errors.rejectValue("username", "user.invalid", "The given username does not exist");
////            model.addAttribute("title", "Log In");
////            return "login";
////        }
////
////        String password = loginFormDTO.getPassword();
////
////        if (!theUser.isMatchingPassword(password)) {
////            errors.rejectValue("password", "password.invalid", "Invalid password");
////            model.addAttribute("title", "Log In");
////            return "login";
////        }
////
////        setUserInSession(request.getSession(), theUser);
////
////        return "redirect:";
////    }
////
////    @GetMapping("/logout")
////    public String logout(HttpServletRequest request){
////        request.getSession().invalidate();
////        return "redirect:/login";
////    }
//
//
//}
//


package com.SimpleTechNoLearning.TechForSTL.controllers;


import com.SimpleTechNoLearning.TechForSTL.data.UserRepository;
import com.SimpleTechNoLearning.TechForSTL.models.User;
import com.SimpleTechNoLearning.TechForSTL.models.dto.LoginFormDTO;
import com.SimpleTechNoLearning.TechForSTL.models.dto.RegisterFormDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value="/")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    private static final String userSessionKey = "user";

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

//        return user.orElse(null);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    @GetMapping(value="/")
    public String hello(){
        return "index";

    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "Register");
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Register");
            return "register";
        }

        User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            model.addAttribute("title", "Register");
//return ResponseEntity.badRequest().body(Collections.singletonMap("error", "User with the given username already exists"));

            return "register";
        }

        String password = registerFormDTO.getPassword();
        String verifyPassword = registerFormDTO.getVerifyPassword();
        if (!password.equals(verifyPassword)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Register");
            return "register";
        }

        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        userRepository.save(newUser);
        setUserInSession(request.getSession(), newUser);
        return "redirect:/";

        //return "redirect:/login";
       // return "redirect:/new-user";

    }
    @GetMapping("/new-user")
    public String displayNewUser(Model model) {
       // model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "NewUser");
        return "new-user";
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }


    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors, HttpServletRequest request,
                                   Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "login";
        }

        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            model.addAttribute("title", "Log In");
            return "login";
        }

        String password = loginFormDTO.getPassword();

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            model.addAttribute("title", "Log In");
            return "login";
        }

        setUserInSession(request.getSession(), theUser);

        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }


    @GetMapping("/help-reset")
    public String reSetPassword(Model model) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Password-reset");
        return "Password-reset";
    }


    @GetMapping("/reset")
    public String displayResetForm(Model model) {
        model.addAttribute(new RegisterFormDTO());
        model.addAttribute("title", "password-reset");
        return "resetpassword";
    }
    @PostMapping("/reset")
    public String processResetPasswordForm(@ModelAttribute @Valid RegisterFormDTO resetFormDTO,
                                          Errors errors, HttpServletRequest request,
                                          Model model) {
        model.addAttribute(new RegisterFormDTO());

        //RegisterFormDTO resetFormDTO = null;
        String password1 = resetFormDTO.getPassword();
        String verifyPassword1 = resetFormDTO.getVerifyPassword();
        if (!password1.equals(verifyPassword1)) {
            errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
            model.addAttribute("title", "Password");
            return "resetpassword";
        }

        User newUser1 = new User(resetFormDTO.getUsername(), resetFormDTO.getPassword());
        userRepository.save(newUser1);
        setUserInSession(request.getSession(), newUser1);
        return "redirect:/";
    }

//
//
//        return "password-reset";
//    }

    }