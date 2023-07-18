package com.instagrocer.webapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.instagrocer.webapp.entity.CatalogEntity;
import com.instagrocer.webapp.entity.OrderEntity;
import com.instagrocer.webapp.entity.OrderItemEntity;

public interface OrderItemRepo extends JpaRepository<OrderItemEntity, Integer>{
	
    @Query("SELECT e FROM OrderItemEntity e WHERE e.orderId = :orderId")
    List<OrderItemEntity> findById(@Param("orderId") int orderId);

}
