package com.luminar.onlinebookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.luminar.onlinebookstore.entity.UserEntity;
import com.luminar.onlinebookstore.service.UserService;

@Controller
public class LoginController {

    @Autowired
    UserService theUserService;

    @GetMapping("/")
    public ModelAndView showLoginPage() {
        return new ModelAndView("Login");
    }

    @PostMapping("/Login")
    public ModelAndView processLogin(String email, String pass) {
        ModelAndView modelAndView = new ModelAndView();

        UserEntity user = theUserService.getUserByEmail(email);

        if (user != null && pass.equals(user.getUserPassword())) {
            // Check user role
            String role = user.getUserRole();
            if ("admin".equalsIgnoreCase(role)) {
                modelAndView.setViewName("redirect:/AdminViewToDoList");
            } else if ("user".equalsIgnoreCase(role)) {
                modelAndView.setViewName("redirect:/ViewToDoList");
            } else {
                // Handle unrecognized role
                modelAndView.addObject("error", "Unrecognized user role");
                modelAndView.setViewName("Login");
            }
        } else {
            modelAndView.addObject("error", "Invalid email or password");
            modelAndView.setViewName("Login");
        }
        return modelAndView;
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
