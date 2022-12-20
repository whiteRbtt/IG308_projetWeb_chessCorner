package com.IG308.chessCorner.dataAccess.dao;

import com.IG308.chessCorner.model.User;

public interface UserDataAccess {
    User findByMailAddress(String mailAddress);
    User save(User user);
}
