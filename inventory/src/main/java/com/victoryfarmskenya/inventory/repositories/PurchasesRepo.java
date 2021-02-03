package com.victoryfarmskenya.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoryfarmskenya.inventory.models.Purchases;

public interface PurchasesRepo extends JpaRepository<Purchases, Integer> {

}
