package com.instagrocer.webapp.service;

import java.util.List;

import com.instagrocer.webapp.dto.CatalogDTO;
import com.instagrocer.webapp.dto.InventoryDTO;
import com.instagrocer.webapp.dto.InventoryUpdateResponseDTO;
import com.instagrocer.webapp.dto.OrderRequestDTO;
import com.instagrocer.webapp.entity.OrderEntity;

public interface InventoryService {
	List<InventoryDTO> getAllItems();

	InventoryUpdateResponseDTO createItem(InventoryDTO inventoryDTO);

	InventoryUpdateResponseDTO updateInventory(InventoryDTO inventoryDTO);

	InventoryUpdateResponseDTO deleteInventoryById(int id);

	InventoryDTO getInventoryById(int id);
	
}
