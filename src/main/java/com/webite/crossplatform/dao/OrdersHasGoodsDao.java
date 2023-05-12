package com.webite.crossplatform.dao;

import com.webite.crossplatform.entities.OrdersHasGoodsEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdersHasGoodsDao extends CrudRepository<OrdersHasGoodsEntity, Integer> {
}
