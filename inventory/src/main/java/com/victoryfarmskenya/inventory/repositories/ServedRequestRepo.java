package com.victoryfarmskenya.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoryfarmskenya.inventory.models.ServedRequests;

public interface ServedRequestRepo extends JpaRepository<ServedRequests, Integer> {

}
