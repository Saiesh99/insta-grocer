package com.instagrocer.webapp.service;

import java.util.List;

import com.instagrocer.webapp.dto.CatalogDTO;
import com.instagrocer.webapp.dto.Order;
import com.instagrocer.webapp.dto.OrderByIdResponse;
import com.instagrocer.webapp.dto.OrderRequestDTO;
import com.instagrocer.webapp.dto.OrderResponse;
import com.instagrocer.webapp.entity.OrderEntity;

public interface OrderService {

	OrderResponse createOrder(Order orderRequestDTO);
//	CatalogDTO updateUser(CatalogDTO userDTO, Integer userId);
//	CatalogDTO getUserById(Integer userId);
//	List<CatalogDTO> getAllUsers();
	//void deleteUserById(Integer userId);

	OrderByIdResponse getOrderById(int id);

	
	
}
