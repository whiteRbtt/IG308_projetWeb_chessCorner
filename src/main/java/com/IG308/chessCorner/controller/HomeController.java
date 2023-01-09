package com.IG308.chessCorner.controller;

import com.IG308.chessCorner.Constants;
import com.IG308.chessCorner.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class HomeController {
    @RequestMapping (method=RequestMethod.GET)
    public String home(Model model, Authentication authentication) {

        model.addAttribute("title", Constants.WEBSITE_NAME);
        return "integrated:homePage";
    }
}
