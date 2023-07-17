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
import com.instagrocer.webapp.dto.OrderRequestDTO;
import com.instagrocer.webapp.entity.OrderEntity;
import com.instagrocer.webapp.service.CatalogService;
import com.instagrocer.webapp.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {
	
	@Autowired
	private CatalogService catalogService;
	
	@Autowired
	private OrderService orderService;

	@PostMapping("/createOrder")
	public ResponseEntity<OrderRequestDTO> createOrder(@RequestBody OrderEntity orderRequestDTO){
		OrderRequestDTO createdUserDTO = orderService.createOrder(orderRequestDTO);
		return new ResponseEntity<>(createdUserDTO,HttpStatus.CREATED);
	}
//	
//	@PutMapping("/update/{userId}")
//	public ResponseEntity<SonyLivUserDTO> updateUser(@Valid @RequestBody SonyLivUserDTO userDTO,@PathVariable("userId") Integer userId){
//		SonyLivUserDTO updatedUserDTO = sonyLivUserService.updateUser(userDTO, userId);
//		return new ResponseEntity<>(updatedUserDTO,HttpStatus.OK);
//	}
//	@DeleteMapping("/delete/{userId}")
//	public ResponseEntity<DeleteApiResponse> deleteUser(@PathVariable("userId") Integer userId){
//		sonyLivUserService.deleteUserById(userId);
//
//		return new ResponseEntity<>(new DeleteApiResponse("user deletd successfully",true),HttpStatus.OK);
//	}
//	
//	@GetMapping("/catalogs")
//	public ResponseEntity<List<CatalogDTO>> getAllUsers(){
//		//this.userService.getAllUsers();
//		return new ResponseEntity<>(catalogService.getAllUsers(),HttpStatus.OK);
//	}
//	
//	@GetMapping("/catalogsByType")
//	public ResponseEntity<List<CatalogDTO>> getCatalogsByType(@RequestParam("type") String type){
//		//this.userService.getAllUsers();
//		return new ResponseEntity<>(catalogService.getCategoriesByType(type),HttpStatus.OK);
//	}	

}
