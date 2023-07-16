package com.instagrocer.webapp.service;

import java.util.List;

import com.instagrocer.webapp.dto.CatalogDTO;

public interface CatalogService {

//	CatalogDTO createUser(CatalogDTO userDTO);
//	CatalogDTO updateUser(CatalogDTO userDTO, Integer userId);
//	CatalogDTO getUserById(Integer userId);
	List<CatalogDTO> getAllUsers();
	//void deleteUserById(Integer userId);
	
	
}
