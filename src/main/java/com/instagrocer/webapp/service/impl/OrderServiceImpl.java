package com.instagrocer.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagrocer.webapp.dto.CatalogDTO;
import com.instagrocer.webapp.dto.InventoryDTO;
import com.instagrocer.webapp.dto.Order;
import com.instagrocer.webapp.dto.OrderByIdResponse;
import com.instagrocer.webapp.dto.OrderRequestDTO;
import com.instagrocer.webapp.dto.OrderResponse;
import com.instagrocer.webapp.entity.CatalogEntity;
import com.instagrocer.webapp.entity.InventoryEntity;
import com.instagrocer.webapp.entity.OrderEntity;
import com.instagrocer.webapp.entity.OrderItemEntity;
import com.instagrocer.webapp.repo.CatalogRepo;
import com.instagrocer.webapp.repo.OrderItemRepo;
import com.instagrocer.webapp.repo.OrderRepo;
import com.instagrocer.webapp.service.CatalogService;
import com.instagrocer.webapp.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private CatalogRepo catalogRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private OrderItemRepo orderItemRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public OrderResponse createOrder(Order orderRequestDTO) {
		//OrderEntity orderEntity = modelMapper.map(orderRequestDTO, OrderEntity.class);
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setAmount(orderRequestDTO.getAmount());
		orderEntity.setUser(orderRequestDTO.getUser());
		OrderEntity savedOrder = orderRepo.save(orderEntity);
		for(Order.Item item : orderRequestDTO.getItems()) {
			OrderItemEntity orderItemEntity = new OrderItemEntity();
			orderItemEntity.setOrderId(savedOrder.getId());
			orderItemEntity.setDescription(item.getDescription());
			orderItemEntity.setPrice(item.getPrice());
			orderItemEntity.setQuantity(item.getQuantity());
			orderItemEntity.setTitle(item.getTitle());
			
			OrderItemEntity savedOrdeEntity = orderItemRepo.save(orderItemEntity);
		}
		
		
	//	System.out.println(orderRequestDTO.getOrderItemList());
	//	System.out.println(orderRequestDTO.getOrderEntities());
		//OrderEntity savedOrder = orderRepo.save(orderEntity);
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setOrderId(savedOrder.getId());
		return orderResponse;
	}
//
//	@Override
//	public CatalogDTO updateUser(CatalogDTO userDTO, Integer userId) {
//		CatalogEntity sonyLivUserEntity = sonyLivUserRepo.findById(userId).get();
//		sonyLivUserEntity.setAbout(userDTO.getAbout());
//		sonyLivUserEntity.setEmail(userDTO.getEmail());
//		sonyLivUserEntity.setName(userDTO.getName());
//		sonyLivUserEntity.setPassword(userDTO.getPassword());
//		CatalogEntity updatedUser = sonyLivUserRepo.save(sonyLivUserEntity);
//		return modelMapper.map(updatedUser, CatalogDTO.class);
//	}
//
//	public List<CatalogDTO> getCategoriesByType(String type) {
//		List<CatalogEntity> catalogs = catalogRepo.findByType(type);
//		List<CatalogDTO> catalogDTOList = catalogs.stream().map(a -> modelMapper.map(a, CatalogDTO.class)).collect(Collectors.toList());
//		return catalogDTOList; 
//	}
//
//	@Override
//	public List<CatalogDTO> getAllUsers() {
//		List<CatalogEntity> catalogs = catalogRepo.findAll();
//		List<CatalogDTO> catalogDTOList = catalogs.stream().map(a -> modelMapper.map(a, CatalogDTO.class)).collect(Collectors.toList());
//		return catalogDTOList;
//	}

	@Override
	public OrderByIdResponse getOrderById(int id) {
		OrderByIdResponse orderByIdResponse = new OrderByIdResponse();
		OrderEntity orderEntity = orderRepo.getById(id);
		orderByIdResponse.setAmount(orderEntity.getAmount());
		orderByIdResponse.setOrderId(orderEntity.getId());
		orderByIdResponse.setUser(orderEntity.getUser());
		orderByIdResponse.setOrderDate("Mon, 15 May 2021 09:43:42 GMT");
		orderByIdResponse.setDeliveryStatus("InProgress");
		
		List<OrderItemEntity> itemEntities = orderItemRepo.findById(id);
		List<OrderByIdResponse.Item> items = new ArrayList<>();
		for(OrderItemEntity entity :itemEntities) {
			OrderByIdResponse.Item item = new OrderByIdResponse.Item();
			item.setDescription(entity.getDescription());
			item.setPrice(entity.getPrice());
			item.setQuantity(entity.getQuantity());
			item.setTitle(entity.getTitle());
			items.add(item);
		}
		orderByIdResponse.setItems(items);
		
		//InventoryEntity catalog = inventoryRepo.findById(id).get();
		//InventoryEntity catalogDTOList = catalogs.stream().map(a -> modelMapper.map(a, CatalogDTO.class)).collect(Collectors.toList());
		//return modelMapper.map(catalog, InventoryDTO.class);
		return orderByIdResponse;
	}

//	@Override
//	public void deleteUserById(Integer userId) {
//
//		sonyLivUserRepo.deleteById(userId);
//		
//	}

}
