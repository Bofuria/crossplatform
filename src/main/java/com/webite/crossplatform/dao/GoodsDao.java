package com.webite.crossplatform.dao;

import com.webite.crossplatform.entities.GoodsEntity;
import com.webite.crossplatform.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsDao extends CrudRepository<GoodsEntity, Integer> { // TODO change Object to required type
    @Query(value = "SELECT meal_count FROM food_item ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer findByMealCount();

    @Query(value = "SELECT day_calories_value FROM food_item ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Integer findCaloriesOfLastRecord();

    @Query(value = "SELECT date FROM food_item ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findDateOfLastRecord();

    @Query(value = "SELECT * FROM goods ORDER BY goods_id DESC", nativeQuery = true)
    List<GoodsEntity> findAllGoods();

}