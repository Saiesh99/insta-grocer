package com.instagrocer.webapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagrocer.webapp.dto.CatalogDTO;
import com.instagrocer.webapp.dto.OrderRequestDTO;
import com.instagrocer.webapp.entity.CatalogEntity;
import com.instagrocer.webapp.entity.OrderEntity;
import com.instagrocer.webapp.repo.CatalogRepo;
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
	private ModelMapper modelMapper;
	
	@Override
	public OrderRequestDTO createOrder(OrderEntity orderRequestDTO) {
		//OrderEntity orderEntity = modelMapper.map(orderRequestDTO, OrderEntity.class);
		//System.out.println(orderRequestDTO.getOrderItemList());
		//System.out.println(orderRequestDTO.getOrderEntities());
		OrderEntity savedOrder = orderRepo.save(orderRequestDTO);
		return modelMapper.map(savedOrder, OrderRequestDTO.class);
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

//	@Override
//	public void deleteUserById(Integer userId) {
//
//		sonyLivUserRepo.deleteById(userId);
//		
//	}

}
