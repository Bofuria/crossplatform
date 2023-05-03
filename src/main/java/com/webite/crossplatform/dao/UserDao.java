package com.webite.crossplatform.dao;

import com.webite.crossplatform.entities.GoodsEntity;
import com.webite.crossplatform.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);
}
