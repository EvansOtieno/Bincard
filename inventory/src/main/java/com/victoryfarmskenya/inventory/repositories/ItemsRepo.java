package com.victoryfarmskenya.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoryfarmskenya.inventory.models.Items;

public interface ItemsRepo extends JpaRepository<Items, Integer> {

}
