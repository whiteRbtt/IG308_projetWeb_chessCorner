package com.IG308.chessCorner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/checkout")
public class CheckoutController {
    @RequestMapping (method=RequestMethod.GET)
    public String checkout(Model model) {
        model.addAttribute("title", "Checkout");
        return "integrated:checkout";
    }
}
