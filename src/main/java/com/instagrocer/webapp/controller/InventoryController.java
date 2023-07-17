package com.instagrocer.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.instagrocer.webapp.dto.CatalogDTO;
import com.instagrocer.webapp.dto.DeleteApiResponse;
import com.instagrocer.webapp.dto.InventoryDTO;
import com.instagrocer.webapp.dto.InventoryUpdateResponseDTO;
import com.instagrocer.webapp.dto.OrderRequestDTO;
import com.instagrocer.webapp.entity.InventoryEntity;
import com.instagrocer.webapp.entity.OrderEntity;
import com.instagrocer.webapp.service.CatalogService;
import com.instagrocer.webapp.service.InventoryService;
import com.instagrocer.webapp.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class InventoryController {
	
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/createItem")
	public ResponseEntity<InventoryUpdateResponseDTO> createOrder(@RequestBody InventoryDTO orderRequestDTO){
		InventoryUpdateResponseDTO createdUserDTO = inventoryService.createItem(orderRequestDTO);
		return new ResponseEntity<>(createdUserDTO,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateItem")
	public ResponseEntity<InventoryUpdateResponseDTO> updateUser( @RequestBody InventoryDTO inventoryDTO){
		InventoryUpdateResponseDTO updatedUserDTO = inventoryService.updateInventory(inventoryDTO);
		return new ResponseEntity<>(updatedUserDTO,HttpStatus.OK);
	}
	@DeleteMapping("/deleteItem/{id}")
	public ResponseEntity<InventoryUpdateResponseDTO> deleteInventory(@PathVariable("id") int id){
		return new ResponseEntity<>(inventoryService.deleteInventoryById(id),HttpStatus.OK);
	}
//	
	@GetMapping("/items")
	public ResponseEntity<List<InventoryDTO>> getAllItems(){
		//this.userService.getAllUsers();
		return new ResponseEntity<>(inventoryService.getAllItems(),HttpStatus.OK);
	}
	
	@GetMapping("/itemById")
	public ResponseEntity<InventoryDTO> getCatalogsByType(@RequestParam("id") int id){
		//this.userService.getAllUsers();
		return new ResponseEntity<>(inventoryService.getInventoryById(id),HttpStatus.OK);
	}	

}
