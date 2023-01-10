package com.IG308.chessCorner.controller;

import com.IG308.chessCorner.Constants;
import com.IG308.chessCorner.model.Basket;
import com.IG308.chessCorner.model.BasketItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/basket")
@SessionAttributes({Constants.BASKET})
public class BasketController {

    @ModelAttribute(Constants.BASKET)
    public Basket basket() {
        return new Basket();
    }

    @RequestMapping(method=RequestMethod.GET)
    public String basket(Model model,
                         @ModelAttribute(value=Constants.BASKET) Basket basket) {

        if(model.containsAttribute("basketItem")){
            basket.addProduct((BasketItem) model.asMap().get("basketItem"));
        }

        model.addAttribute("title", Constants.WEBSITE_NAME);
        model.addAttribute("basket", basket);
        return "integrated:basket";
    }

    @RequestMapping(value="", method = RequestMethod.POST, params = "updateCart")
    public String basketUpdate(Model model, @Valid @ModelAttribute(value=Constants.BASKET) Basket basket, final BindingResult result){
        model.addAttribute("title", Constants.WEBSITE_NAME);
        if(result.hasErrors()){
            return "integrated:basket";
        }
        basket.getBasketProducts().entrySet().removeIf(entry -> entry.getValue().getQuantity() <= 0);

        basket.getBasketProducts().entrySet().forEach(entry -> {
            if(entry.getValue().getQuantity() > Constants.STOCK){
                entry.getValue().setQuantity(Constants.STOCK);
            }
        });
        return "integrated:basket";
    }

    @RequestMapping(value="", method = RequestMethod.POST, params = "placeOrder")
    public String placeOrder(Model model,
                             @Valid @ModelAttribute(value=Constants.BASKET) Basket basket,
                             final BindingResult result,
                             RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            model.addAttribute("title", Constants.WEBSITE_NAME);
            return "integrated:basket";
        }

        return "redirect:/checkout";
    }
}
