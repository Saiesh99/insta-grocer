package com.instagrocer.webapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.instagrocer.webapp.entity.CatalogEntity;

public interface CatalogRepo extends JpaRepository<CatalogEntity, Integer>{

}
