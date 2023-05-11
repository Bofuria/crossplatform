package com.webite.crossplatform.dao;

import com.webite.crossplatform.entities.OrdersEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<OrdersEntity, Integer> {
}
