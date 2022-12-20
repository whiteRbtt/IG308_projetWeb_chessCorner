package com.IG308.chessCorner.dataAccess.repository;

import com.IG308.chessCorner.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByMailAddress(String mailAddress);
}
