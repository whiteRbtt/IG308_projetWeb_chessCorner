package com.IG308.chessCorner.controller;

import com.IG308.chessCorner.Constants;
import com.IG308.chessCorner.dataAccess.dao.OrderDataAccess;
import com.IG308.chessCorner.dataAccess.dao.OrderLineDataAccess;
import com.IG308.chessCorner.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.beans.Transient;
import java.util.Formatter;

@Controller
@RequestMapping(value="/checkout")
@SessionAttributes({Constants.BASKET})
public class CheckoutController {

    private OrderDataAccess orderDAO;
    private OrderLineDataAccess orderLineDAO;

    @Autowired
    public void AddOrderDAO(OrderDataAccess orderDAO){
        this.orderDAO = orderDAO;
    }

    @Autowired
    public void AddOrderLineDAO(OrderLineDataAccess orderLineDAO){
        this.orderLineDAO = orderLineDAO;
    }

    @ModelAttribute(Constants.BASKET)
    public Basket basket() {
        return new Basket();
    }

    @RequestMapping (method=RequestMethod.GET)
    public String checkout(Model model,
                           @ModelAttribute(value=Constants.BASKET) Basket basket) {

        if(basket.getBasketProducts().isEmpty()){
            return "redirect:/";
        }

        double totalPriceBasket = 0.0;
        for (BasketItem basketItem : basket.getBasketProducts().values()) {
            totalPriceBasket += basketItem.getQuantity() * basketItem.getProduct().getPrice();
        }

        model.addAttribute("total", totalPriceBasket);
        model.addAttribute("title", Constants.WEBSITE_NAME);
        return "integrated:checkout";
    }

    @Transactional
    @RequestMapping(value="", method = RequestMethod.POST, params = "proceedCheckout")
    public String confirmOrder(Model model,
                               @Valid @ModelAttribute(value=Constants.BASKET) Basket basket,
                               Authentication authentication){

        Double orderPrice = 0.0;

        Order savedOrder = orderDAO.save(new Order(
                new java.util.Date(),
                (User) authentication.getPrincipal(),
                false
        ));

        for (BasketItem basketItem : basket.getBasketProducts().values()) {
            double orderLinePrice = basketItem.getProduct().getPrice() * basketItem.getQuantity();
            orderPrice += orderLinePrice;

            OrderLine orderLine = new OrderLine(
                    basketItem.getProduct(),
                    savedOrder,
                    basketItem.getQuantity(),
                    Math.round(orderLinePrice * 100.0) / 100.0
            );
            orderLineDAO.save(orderLine);
        }

        model.addAttribute("title", Constants.WEBSITE_NAME);
        model.addAttribute("orderPrice", Math.round(orderPrice * 100.0) / 100.0);
        model.addAttribute("orderId", savedOrder.getOrderId());
        return "integrated:checkout";
    }

    @RequestMapping(value="/cancel", method = RequestMethod.GET)
    public String cancelOrder(Model model,
                              @RequestParam("orderId") Integer orderId,
                              @Valid @ModelAttribute(value=Constants.BASKET) Basket basket){

        // effectuer les traitements pour annuler la commande ou proposer de payer plus tard

        return "redirect:/basket";
    }

    @RequestMapping(value="/confirm", method = RequestMethod.GET)
    public String successOrder(Model model,
                               @RequestParam("orderId") Integer orderId,
                               @Valid @ModelAttribute(value=Constants.BASKET) Basket basket){

        orderDAO.getOrderById(orderId).setIsPaid(true);
        basket.getBasketProducts().clear();

        System.out.println("thanks for your purchase");

        return "redirect:/";
    }
}
