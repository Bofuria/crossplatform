package com.webite.crossplatform.dao;

import com.webite.crossplatform.entities.GoodsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

    public interface GoodsDao extends CrudRepository<GoodsEntity, Integer> { // TODO change Object to required type

    @Query(value = "SELECT * FROM goods ORDER BY goods_id DESC", nativeQuery = true)
    List<GoodsEntity> findAllGoods();

}