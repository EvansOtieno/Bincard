package com.victoryfarmskenya.inventory.services;

import java.util.List;

import com.victoryfarmskenya.inventory.models.Users;

public interface UserService {
	List<Users> findAll();
	Users save(Users user);
	Users findById(int id);
	Users findByEmail(String email);
	void delete(int id);
	Boolean existsByEmail(String email);
	void reset();
}