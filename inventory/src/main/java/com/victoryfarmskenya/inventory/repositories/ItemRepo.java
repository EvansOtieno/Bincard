package com.victoryfarmskenya.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.victoryfarmskenya.inventory.models.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

	 @Transactional
		@Modifying
		@Query(value = "update Item u set u.qnty = u.qnty + ? where u.id = ?", 
		  nativeQuery = true)
		int updateitem(@Param("qnty") int qnty,@Param("id") int id);
	 @Transactional
		@Modifying
		@Query(value = "update Item u set u.qnty = u.qnty - ? where u.id = ?", 
		  nativeQuery = true)
		int itemupdate(@Param("qnty") int qnty,@Param("id") int id);
	Boolean existsByItem(String item);

	Item findByItem(String item);
}
