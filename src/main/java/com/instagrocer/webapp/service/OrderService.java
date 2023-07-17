package com.instagrocer.webapp.service;

import java.util.List;

import com.instagrocer.webapp.dto.CatalogDTO;
import com.instagrocer.webapp.dto.OrderRequestDTO;
import com.instagrocer.webapp.entity.OrderEntity;

public interface OrderService {

	OrderRequestDTO createOrder(OrderEntity orderRequestDTO);
//	CatalogDTO updateUser(CatalogDTO userDTO, Integer userId);
//	CatalogDTO getUserById(Integer userId);
//	List<CatalogDTO> getAllUsers();
	//void deleteUserById(Integer userId);

	
	
}
