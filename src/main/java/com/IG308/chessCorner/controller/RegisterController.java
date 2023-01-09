package com.IG308.chessCorner.controller;

import com.IG308.chessCorner.Constants;
import com.IG308.chessCorner.dataAccess.dao.UserDAO;
import com.IG308.chessCorner.dataAccess.dao.UserDataAccess;
import com.IG308.chessCorner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
@RequestMapping(value="/register")
public class RegisterController {

    private UserDataAccess userDAO;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegisterController(){
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Autowired
    public void AddUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @RequestMapping (method=RequestMethod.GET)
    public String register(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("title", Constants.WEBSITE_NAME);
        return "integrated:register";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String registration(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return "integrated:register";
        }

        User userDB = userDAO.findByMailAddress(user.getUsername());
        if(userDB != null){
            bindingResult.addError(new FieldError("user", "username", "already registered"));
            model.addAttribute("alreadyRegistered", "alreadyRegistered");
            return "integrated:register";
        }

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(user.getBirthDate());
        if(calendar.get(Calendar.YEAR) < Constants.MIN_YEAR){
            bindingResult.addError(new FieldError("user", "birthDate", "minYearNotValid"));
            model.addAttribute("minYearNotValid", "minYearNotValid");
            return "integrated:register";
        }

        String clearPassword = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User createdUser = userDAO.save(user);

        try {
            request.login(createdUser.getUsername(), clearPassword);
        } catch(ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
