package com.victoryfarmskenya.inventory.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.victoryfarmskenya.inventory.models.Users;


@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);
	Boolean existsByEmail(String email);
	
	@Transactional
	@Procedure(procedureName = "RESET")
	void reset();
}
