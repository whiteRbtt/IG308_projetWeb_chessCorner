package com.IG308.chessCorner.controller;

import com.IG308.chessCorner.Constants;
import com.IG308.chessCorner.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/login")
public class LoginController {

    @RequestMapping (method=RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", Constants.WEBSITE_NAME);
        return "integrated:login";
    }

}
