package com.SimpleTechNoLearning.TechForSTL;

import com.SimpleTechNoLearning.TechForSTL.controllers.AuthenticationController;
import com.SimpleTechNoLearning.TechForSTL.data.UserRepository;
import com.SimpleTechNoLearning.TechForSTL.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter implements HandlerInterceptor {

@Autowired
    private UserRepository userRepository;
@Autowired
    private AuthenticationController authenticationController;



    private static final List<String> whitelist = Arrays.asList("/login", "/register", "/logout", "/css");
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);

        // The user is logged in
        if (user != null) {
            return true;
        }

        // The user is NOT logged in
        response.sendRedirect("/login");
        return false;
    }


}
