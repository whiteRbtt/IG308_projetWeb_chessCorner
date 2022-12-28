package com.IG308.chessCorner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.IG308.chessCorner.Constants;

@Controller
@RequestMapping(value="/about")
public class AboutController {

    @RequestMapping (method=RequestMethod.GET)
    public String about(Model model) {

        model.addAttribute("title", Constants.WEBSITE_NAME);
        return "integrated:about";
    }
}
