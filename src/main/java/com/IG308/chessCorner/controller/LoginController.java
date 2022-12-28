package com.IG308.chessCorner.controller;

import com.IG308.chessCorner.Constants;
import com.IG308.chessCorner.dataAccess.dao.*;
import com.IG308.chessCorner.model.Order;
import com.IG308.chessCorner.model.OrderLine;
import com.IG308.chessCorner.model.Product;
import com.IG308.chessCorner.model.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/login")
public class LoginController {

    private UserDataAccess userDataAccess;
    private ProductDataAccess productDataAccess;
    private OrderDataAccess orderDataAccess;
    private OrderLineDataAccess orderLineDataAccess;

    @Autowired
    public void addUserDAO(UserDAO userDAO){
        this.userDataAccess = userDAO;
    }

    @Autowired
    public void addProductDAO(ProductDAO productDAO){
        this.productDataAccess = productDAO;
    }

    @Autowired
    public void addOrderDAO(OrderDAO orderDAO){
        this.orderDataAccess = orderDAO;
    }

    @Autowired
    public void addOrderLineDAO(OrderLineDAO orderLineDAO){
        this.orderLineDataAccess = orderLineDAO;
    }


    @RequestMapping (method=RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", Constants.WEBSITE_NAME);
        return "integrated:login";
    }

    @RequestMapping (value="/send", method=RequestMethod.POST)
    public String getFormData(@ModelAttribute(value="user") User loginForm) {

//        // TOREMOVE
//        // testing crud
//
//        // user
//        User user = userDataAccess.findByMailAddress(loginForm.getUsername());
//        System.out.println("user : " + user);
//
//        User u1 = new User("testtest@pm.me", "loremipsum", null, "loremipsum", "loremipsum", new Date(), "loremipsum");
//        u1 = userDataAccess.save(u1);
//
//        // product
//        Product product = productDataAccess.getProductById(9);
//        List<Product> products = productDataAccess.findAll();
//
//        System.out.println("product : " + product);
//        products.forEach(System.out::println);
//
//        // order
//        Order order = new Order(new Date(), userDataAccess.findByMailAddress(loginForm.getUsername()), false);
//        order = orderDataAccess.save(order);
//
//        System.out.println("order id : " + order.getOrderId());
//
//        // orderLine
//
//        Product p1 = productDataAccess.getProductById(1);
//        Product p2 = productDataAccess.getProductById(2);
//
//        OrderLine orderLine = new OrderLine(p1, order, 1, 9.99);
//        OrderLine orderLine2 = new OrderLine(p2, order, 2, 19.99);
//
//        orderLineDataAccess.save(orderLine);
//        orderLineDataAccess.save(orderLine2);
//
//        System.out.println("je paye mon panier");
//
//        // payment
//        // Order orderToPay = orderDataAccess.getOrderById(4);
//        order.setIsPaid(true);
//        orderDataAccess.save(order);


        return "integrated:login";
    }
}
