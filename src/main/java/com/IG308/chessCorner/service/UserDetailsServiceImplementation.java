package com.IG308.chessCorner.service;

import com.IG308.chessCorner.dataAccess.dao.UserDAO;
import com.IG308.chessCorner.dataAccess.dao.UserDataAccess;
import com.IG308.chessCorner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserDataAccess userDataAccess;

    @Autowired
    public UserDetailsServiceImplementation(UserDAO userDAO){
        this.userDataAccess = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String mailAddress) throws UsernameNotFoundException{
        User user = userDataAccess.findByMailAddress(mailAddress);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
