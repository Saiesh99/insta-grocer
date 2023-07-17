package com.instagrocer.webapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.instagrocer.webapp.entity.CatalogEntity;
import com.instagrocer.webapp.entity.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer>{
	
//    @Query("SELECT e FROM CatalogEntity e WHERE e.type = :type")
//    List<CatalogEntity> findByType(@Param("type") String type);

}
