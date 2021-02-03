package com.victoryfarmskenya.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.victoryfarmskenya.inventory.models.ItemRequest;

public interface ItemRequestRepo extends JpaRepository<ItemRequest, Integer> {

	@Transactional
	@Modifying
	@Query(value = "update item_request u set u.complete = !u.complete where u.id = ?", 
	  nativeQuery = true)
	int updatecomplete(@Param("id") int id);
}
