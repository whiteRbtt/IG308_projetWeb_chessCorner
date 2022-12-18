package com.IG308.chessCorner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/product")
public class ProductController {

    @RequestMapping (method=RequestMethod.GET)
    public String product(Model model) {
        model.addAttribute("title", "Product");
        return "integrated:product";
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String allProducts(Model model) {
        model.addAttribute("title", "All products");
        return "integrated:products";
    }
}
