package com.example.musicsec.web;

import com.example.musicsec.model.binding.UserRegisterBindingModel;
import com.example.musicsec.model.serviceModels.UserRegisterServiceModel;
import com.example.musicsec.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController (ModelMapper modelMapper,UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login () {

        return "login";
    }

    @GetMapping("/register")
    public String register (Model model) {
        if (!model.containsAttribute ("userRegisterBindingModel")) {
            model.addAttribute ("userRegisterBindingModel",new UserRegisterBindingModel ());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerAndLoginUser (@Valid UserRegisterBindingModel userRegisterBindingModel,
                                        BindingResult bindingResult,
                                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors ()) {
            redirectAttributes.addFlashAttribute ("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes.addFlashAttribute ("org.springframework.validation.BindingResult.userRegisterBindingModel",bindingResult);
            return "redirect:/users/register";
        }
        if (this.userService.userNameExists (userRegisterBindingModel.getUsername ())) {
            redirectAttributes.addFlashAttribute ("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes.addFlashAttribute ("userExistsError",true);
            return "redirect:/users/register";
        }
        var userServiceModel = modelMapper.map (userRegisterBindingModel,UserRegisterServiceModel.class);
        this.userService.registerAndLoginUser (userServiceModel);

        return "redirect:/home";
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
