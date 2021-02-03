package com.victoryfarmskenya.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victoryfarmskenya.inventory.models.Locations;

public interface LocationsRepo extends JpaRepository<Locations, Integer> {

}
