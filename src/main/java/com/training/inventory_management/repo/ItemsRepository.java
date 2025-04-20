package com.training.inventory_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.inventory_management.entities.ItemsEntity;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity, Integer>{

}
