package com.IG308.chessCorner.dataAccess.util;

import com.IG308.chessCorner.dataAccess.entity.*;
import com.IG308.chessCorner.model.*;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = mapper.map(user, UserEntity.class);
        userEntity.setMailAddress(user.getUsername());
        userEntity.setHashedPwd(user.getPassword());
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = mapper.map(userEntity, User.class);
        user.setUsername(userEntity.getMailAddress());
        user.setPassword(userEntity.getHashedPwd());
        return user;
    }

}
