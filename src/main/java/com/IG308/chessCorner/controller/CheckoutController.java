package com.IG308.chessCorner.controller;

import com.IG308.chessCorner.Constants;
import com.IG308.chessCorner.dataAccess.dao.OrderDataAccess;
import com.IG308.chessCorner.dataAccess.dao.OrderLineDataAccess;
import com.IG308.chessCorner.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;


@Controller
@RequestMapping(value="/checkout")
@SessionAttributes({Constants.BASKET})
public class CheckoutController {

    private OrderDataAccess orderDataAccess;
    private OrderLineDataAccess orderLineDataAccess;

    @Autowired
    public void AddOrderDAO(OrderDataAccess orderDAO){
        this.orderDataAccess = orderDAO;
    }

    @Autowired
    public void AddOrderLineDAO(OrderLineDataAccess orderLineDAO){
        this.orderLineDataAccess = orderLineDAO;
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

        Order savedOrder = orderDataAccess.save(new Order(
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
            orderLineDataAccess.save(orderLine);
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

        // traitements à effectuer :
        // soit supprimer la commande non payée de la DB
        // soit proposer à l'utilisateur de payer un commande enregistrée

        return "redirect:/basket";
    }

    @RequestMapping(value="/success", method = RequestMethod.GET)
    public String successOrder(Model model,
                               @RequestParam("orderId") Integer orderId,
                               @Valid @ModelAttribute(value=Constants.BASKET) Basket basket){

        Order paidOrder = orderDataAccess.getOrderById(orderId);
        paidOrder.setIsPaid(true);
        orderDataAccess.save(paidOrder);

        basket.getBasketProducts().clear();

        return "redirect:/";
    }
}
