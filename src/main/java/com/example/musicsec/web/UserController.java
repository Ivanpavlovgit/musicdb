package com.example.musicsec.web;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @GetMapping("/register")
    public String register () {
        return "register";
    }

    @PostMapping("/login-error")
    public ModelAndView failedLogin (@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String userName) {
        var mav = new ModelAndView ();
        mav.addObject ("bad_credentials",true);
        mav.addObject ("username",userName);
        mav.setViewName ("/login");

        return mav;
    }
}
