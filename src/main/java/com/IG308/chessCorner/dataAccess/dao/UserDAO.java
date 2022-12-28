package com.IG308.chessCorner.dataAccess.dao;

import com.IG308.chessCorner.dataAccess.entity.UserEntity;
import com.IG308.chessCorner.dataAccess.repository.UserRepository;
import com.IG308.chessCorner.dataAccess.util.ProviderConverter;
import com.IG308.chessCorner.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserDAO implements UserDataAccess{
    private UserRepository userRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public UserDAO(UserRepository userRepository, ProviderConverter providerConverter) {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    public User findByMailAddress(String mailAddress) {
        UserEntity userEntity = userRepository.findByMailAddress(mailAddress);
        if(userEntity == null){
            return null;
        }
        return providerConverter.userEntityToUserModel(userEntity);
    }

    @Override
    public User save(User user){
        UserEntity userEntity = providerConverter.userModelToUserEntity(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return providerConverter.userEntityToUserModel(savedUserEntity);
    }
}
