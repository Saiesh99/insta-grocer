package com.instagrocer.webapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagrocer.webapp.dto.CatalogDTO;
import com.instagrocer.webapp.dto.InventoryDTO;
import com.instagrocer.webapp.dto.InventoryUpdateResponseDTO;
import com.instagrocer.webapp.dto.OrderRequestDTO;
import com.instagrocer.webapp.entity.CatalogEntity;
import com.instagrocer.webapp.entity.InventoryEntity;
import com.instagrocer.webapp.entity.OrderEntity;
import com.instagrocer.webapp.repo.CatalogRepo;
import com.instagrocer.webapp.repo.InventoryRepo;
import com.instagrocer.webapp.repo.OrderRepo;
import com.instagrocer.webapp.service.CatalogService;
import com.instagrocer.webapp.service.InventoryService;
import com.instagrocer.webapp.service.OrderService;
@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private CatalogRepo catalogRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private InventoryRepo inventoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public InventoryUpdateResponseDTO createItem(InventoryDTO inventoryDTO) {
		InventoryEntity inventoryEntity = modelMapper.map(inventoryDTO, InventoryEntity.class);
		//System.out.println(orderRequestDTO.getOrderItemList());
		//System.out.println(orderRequestDTO.getOrderEntities());
		InventoryUpdateResponseDTO inventoryUpdateResponseDTO = new InventoryUpdateResponseDTO();
		InventoryEntity savedOrder = inventoryRepo.save(inventoryEntity);
		inventoryUpdateResponseDTO.setItemId(savedOrder.getItemId());
		inventoryUpdateResponseDTO.setTitle(savedOrder.getTitle());
		inventoryUpdateResponseDTO.setStatus("added");
		return inventoryUpdateResponseDTO;
	}
//
	@Override
	public InventoryUpdateResponseDTO updateInventory(InventoryDTO inventoryDTO) {
		InventoryEntity sonyLivUserEntity = inventoryRepo.findById(inventoryDTO.getItemId()).get();
		sonyLivUserEntity.setTitle(inventoryDTO.getTitle());
		sonyLivUserEntity.setType(inventoryDTO.getType());
		sonyLivUserEntity.setDescription(inventoryDTO.getDescription());
		sonyLivUserEntity.setPrice(inventoryDTO.getPrice());
		sonyLivUserEntity.setQuantityDate(inventoryDTO.getQuantityDate());
		sonyLivUserEntity.setQuantity(inventoryDTO.getQuantity());
		InventoryEntity updatedUser = inventoryRepo.save(sonyLivUserEntity);
		InventoryUpdateResponseDTO inventoryUpdateResponseDTO = new InventoryUpdateResponseDTO();
		inventoryUpdateResponseDTO.setItemId(updatedUser.getItemId());
		inventoryUpdateResponseDTO.setTitle(updatedUser.getTitle());
		inventoryUpdateResponseDTO.setStatus("updated");
		return inventoryUpdateResponseDTO;
	}
//
	@Override
	public InventoryDTO getInventoryById(int id) {
		InventoryEntity catalog = inventoryRepo.findById(id).get();
		//InventoryEntity catalogDTOList = catalogs.stream().map(a -> modelMapper.map(a, CatalogDTO.class)).collect(Collectors.toList());
		return modelMapper.map(catalog, InventoryDTO.class);
	}
//
	@Override
	public List<InventoryDTO> getAllItems() {
		List<InventoryEntity> inventories = inventoryRepo.findAll();
		List<InventoryDTO> inventoryDTOList = inventories.stream().map(a -> modelMapper.map(a, InventoryDTO.class)).collect(Collectors.toList());
		return inventoryDTOList;
	}

	@Override
	public InventoryUpdateResponseDTO deleteInventoryById(int id) {
		InventoryEntity catalog = inventoryRepo.findById(id).get();
		InventoryUpdateResponseDTO inventoryUpdateResponseDTO = new InventoryUpdateResponseDTO();
		inventoryUpdateResponseDTO.setItemId(catalog.getItemId());
		inventoryUpdateResponseDTO.setTitle(catalog.getTitle());
		inventoryUpdateResponseDTO.setStatus("deleted");
		inventoryRepo.deleteById(id);
		return inventoryUpdateResponseDTO;
		
	}

}
