package com.IG308.chessCorner.controller;

import com.IG308.chessCorner.Constants;
import com.IG308.chessCorner.dataAccess.dao.ProductDAO;
import com.IG308.chessCorner.dataAccess.dao.ProductDataAccess;
import com.IG308.chessCorner.model.BasketItem;
import com.IG308.chessCorner.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value="/product")
public class ProductController {

    private ProductDataAccess productDataAccess;

    @Autowired
    public void addProductDAO(ProductDAO productDAO){
        this.productDataAccess = productDAO;
    }


    @RequestMapping (method=RequestMethod.GET)
    public String product(Model model,
                          @RequestParam("id")String productId,
                          @CookieValue(value="localeCookie", defaultValue="fr") String locale) {

        Product product = productDataAccess.getProductById(Integer.parseInt(productId));

        product.getProductTranslations().forEach(translation -> {
            if (translation.getLanguage().getCode().equals(locale)) {
                model.addAttribute("name", translation.getProductName());
                model.addAttribute("description", translation.getProductDescription());
            }
        });

        if(!model.containsAttribute("basketItem")){
            model.addAttribute("basketItem", new BasketItem());
        }
        model.addAttribute("product", product);
        model.addAttribute("title", Constants.WEBSITE_NAME);
        return "integrated:product";
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String allProducts(Model model) {

        List<Product> products = productDataAccess.findAll();
        model.addAttribute("title", Constants.WEBSITE_NAME);
        model.addAttribute("products", products);
        return "integrated:products";
    }

    @RequestMapping (value="/add", method=RequestMethod.POST)
    public String addToBasket(
            @RequestParam("id")String productId,
            @Valid @ModelAttribute(value="basketItem") BasketItem basketItem,
            final BindingResult errors,
            RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.basketItem", errors);
            redirectAttributes.addFlashAttribute("basketItem", basketItem);
            return "redirect:/product?id="+productId;
        } else {

            // appliquer promotions ici

            basketItem.setProduct(productDataAccess.getProductById(Integer.parseInt(productId)));
            redirectAttributes.addFlashAttribute("basketItem", basketItem);
            return "redirect:/basket";
        }
    }
}
