//package com.SimpleTechNoLearning.TechForSTL.controllers.api;
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
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//public class AuthenticationApi {
//
//    package com.SimpleTechNoLearning.TechForSTL.controllers;
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
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//    @Controller
//    public class AuthenticationController {
//        @Autowired
//        private UserRepository userRepository;
//        private static final String userSessionKey = "user";
//
//        @GetMapping("/")
//        @ResponseBody
//        public String hello(){
//
//            return "Hello Viewers";
//        }
//
//        public User getUserFromSession(HttpSession session) {
//            Integer userId = (Integer) session.getAttribute(userSessionKey);
//            if (userId == null) {
//                return null;
//            }
//
//            Optional<User> user = userRepository.findById(userId);
//
//            if (user.isEmpty()) {
//                return null;
//            }
//
//            return user.get();
//        }
//
//        private static void setUserInSession(HttpSession session, User user) {
//            session.setAttribute(userSessionKey, user.getId());
//        }
//
//
//        @GetMapping("/register")
//        public String displayRegistrationForm(Model model) {
//            model.addAttribute(new RegisterFormDTO());
//            model.addAttribute("title", "Register");
//            return "register";
//        }
//
//        @PostMapping("/register")
//        public ResponseEntity<Map<String, Object>> processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
//                                                                           Errors errors, HttpServletRequest request,
//                                                                           Model model) {
//
//            if (errors.hasErrors()) {
//                // Log validation errors
//                errors.getAllErrors().forEach(error -> System.err.println(error));
//
//                // Construct and return validation errors in the expected format
//                Map<String, Object> response = new HashMap<>();
////                Object ValidationUtil = null;
////response.put("errors", ValidationUtil.getErrorsMap(errors));
//                return ResponseEntity.badRequest().body(response);
//            }
//
//            User existingUser = userRepository.findByUsername(registerFormDTO.getUsername());
////            User existingUserByEmail = userRepository.findByEmail(registerFormDTO.getEmail());
//
//            if (existingUser != null) {
//                errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
//                model.addAttribute("title", "Register");
//            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "User with the given username already exists"));
//
//            }
////            if (existingUserByEmail != null) {
////                errors.rejectValue("email", "email.alreadyexists", "That email already exists, try a different one.");
////                model.addAttribute("title", "Register");
////            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "User with the given email already exists"));
////
////            }
//
//            String password = registerFormDTO.getPassword();
//            String verifyPassword = registerFormDTO.getVerifyPassword();
//            if (!password.equals(verifyPassword)) {
//                errors.rejectValue("password", "passwords.mismatch", "Passwords do not match");
//                model.addAttribute("title", "Register");
//            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Passwords do not match"));
//
//            }
//
////            User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getEmail(),registerFormDTO.getPassword(),registerFormDTO.getVerifyPassword());
//                      // User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword(),registerFormDTO.getVerifyPassword());
//
//            User newUser = null;
//            userRepository.save(newUser);
//            setUserInSession(request.getSession(), newUser);
//
//           // return "redirect:";
//            return ResponseEntity.accepted().build();
//        }
//
//        @GetMapping("/login")
//        public String displayLoginForm(Model model) {
//            model.addAttribute(new LoginFormDTO());
//            model.addAttribute("title", "Log In");
//            return "login";
//        }
//
//
//        @PostMapping("/login")
//        public ResponseEntity<Map<String, Object>> processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
//                                                                    Errors errors, HttpServletRequest request,
//                                                                    Model model) {
//
//            if (errors.hasErrors()) {
//                Map<String, Object> response = new HashMap<>();
//                response.put("errors", errors.getAllErrors());
//                model.addAttribute("title", "Log In");
//                return ResponseEntity.badRequest().body(response);
////            return "login";
//            }
//
//            User theUser = userRepository.findByUsername(loginFormDTO.getUsername());
//
//            if (theUser == null) {
//                errors.rejectValue("username", "user.invalid", "The given username does not exist");
//                model.addAttribute("title", "Log In");
//
//
//                // Initialize the response map
//                Map<String, Object> response = new HashMap<>();
//                response.put("errors", Collections.singletonMap("username", "The given username does not exist"));
//                return ResponseEntity.badRequest().body(response);
////            return "login";
//            }
//
//            String password = loginFormDTO.getPassword();
//
//            if (!theUser.isMatchingPassword(password)) {
//                errors.rejectValue("password", "password.invalid", "Invalid password");
//
//                // Initialize the response map
//                Map<String, Object> response = new HashMap<>();
//                response.put("errors", Collections.singletonMap("password", "Incorrect password"));
//                return ResponseEntity.badRequest().body(response);
//
////            return "login";
//            }
//
//            setUserInSession(request.getSession(), theUser);
//            return ResponseEntity.ok(Collections.emptyMap());
////        return "redirect:";
//        }
//
//        @GetMapping("/logout")
//        public ResponseEntity<String> logout(HttpServletRequest request){
//            request.getSession().invalidate();
//            return ResponseEntity.ok("success");
////        return "redirect:/login";
//        }
//
//
//    }
//
//
//}
