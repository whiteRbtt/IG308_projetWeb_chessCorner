package com.IG308.chessCorner.controller;

import com.IG308.chessCorner.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController {
    @RequestMapping (method=RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "Login");
        return "integrated:login";
    }

    @RequestMapping (value="/send", method=RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="user") User loginForm) {
        System.out.println(loginForm.getUsername());
        System.out.println(loginForm.getPassword());
        return "integrated:login";
    }
}
