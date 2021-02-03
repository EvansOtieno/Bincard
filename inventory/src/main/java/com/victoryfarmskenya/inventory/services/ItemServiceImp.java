package com.victoryfarmskenya.inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victoryfarmskenya.inventory.models.Item;
import com.victoryfarmskenya.inventory.models.ItemRequest;
import com.victoryfarmskenya.inventory.models.Items;
import com.victoryfarmskenya.inventory.models.Locations;
import com.victoryfarmskenya.inventory.models.Purchases;
import com.victoryfarmskenya.inventory.models.ServedItems;
import com.victoryfarmskenya.inventory.models.ServedRequests;
import com.victoryfarmskenya.inventory.repositories.ItemRepo;
import com.victoryfarmskenya.inventory.repositories.ItemRequestRepo;
import com.victoryfarmskenya.inventory.repositories.ItemsRepo;
import com.victoryfarmskenya.inventory.repositories.LocationsRepo;
import com.victoryfarmskenya.inventory.repositories.PurchasesRepo;
import com.victoryfarmskenya.inventory.repositories.ServedItemsRepo;
import com.victoryfarmskenya.inventory.repositories.ServedRequestRepo;
import com.victoryfarmskenya.inventory.repositories.UserRepo;

@Service
public class ItemServiceImp implements ItemService {

	@Autowired
	ItemsRepo itr;
	@Autowired
	LocationsRepo lr;
	@Autowired
	ItemRepo ir;
	@Autowired
	ItemRequestRepo irr;
	@Autowired
	PurchasesRepo pr;
	@Autowired
	ServedRequestRepo srr;
	@Autowired
	UserRepo ur;
	@Autowired
	ServedItemsRepo sir;

	@Override
	public List<Item> findAllItem() {
		// TODO Auto-generated method stub
		return ir.findAll();
	}

	@Override
	public Item saveItem(Item item) {
		// TODO Auto-generated method stub
		return ir.save(item);
	}

	@Override
	public Optional<Item> findItemById(int id) {
		// TODO Auto-generated method stub
		return ir.findById(id);
	}

	@Override
	public Item findByItem(String item) {
		// TODO Auto-generated method stub
		return ir.findByItem(item);
	}

	@Override
	public void deleteItem(int id) {
		// TODO Auto-generated method stub
		ir.deleteById(id);
	}

	@Override
	public Boolean existsByItem(String item) {
		// TODO Auto-generated method stub
		return ir.existsByItem(item);
	}

	@Override
	public List<ItemRequest> findAllRequest() {
		// TODO Auto-generated method stub
		return irr.findAll();
	}

	@Override
	public ItemRequest saveRequest(ItemRequest item) {
		// TODO Auto-generated method stub
		return irr.save(item);
	}

	@Override
	public Optional<ItemRequest> findItemRequestById(int id) {
		// TODO Auto-generated method stub
		return irr.findById(id);
	}

	@Override
	public void deleteItemRequest(int id) {
		// TODO Auto-generated method stub
		irr.deleteById(id);
	}

	@Override
	public List<ServedRequests> findAllServedRequest() {
		// TODO Auto-generated method stub
		return srr.findAll();
	}

	@Override
	public ServedRequests saveServedRequest(ServedRequests item) {
		// TODO Auto-generated method stub
		return srr.save(item);
	}

	@Override
	public Optional<ServedRequests> findServedRequestById(int id) {
		// TODO Auto-generated method stub
		return srr.findById(id);
	}

	@Override
	public void deleteServedRequest(int id) {
		// TODO Auto-generated method stub
		srr.deleteById(id);
	}

	@Override
	public List<Purchases> findAllPurchases() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Purchases savePurchase(Purchases item) {
		// TODO Auto-generated method stub
		return pr.save(item);
	}

	@Override
	public Purchases findPurchasesById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePurchases(int id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

	@Override
	public int updateItem(int qnty, int id) {
		// TODO Auto-generated method stub
		return ir.updateitem(qnty, id);
	}

	@Override
	public int updateComplete(int id) {
		
		return irr.updatecomplete(id);
	}

	@Override
	public List<Items> findAllItems() {
		// TODO Auto-generated method stub
		return itr.findAll();
	}

	@Override
	public Items saveItems(Items item) {
		// TODO Auto-generated method stub
		return itr.save(item);
	}

	@Override
	public List<Locations> findAllLocations() {
		// TODO Auto-generated method stub
		return lr.findAll();
	}

	@Override
	public Locations saveLocation(Locations location) {
		// TODO Auto-generated method stub
		return lr.save(location);
	}

	@Override
	public List<ServedItems> getServedItems() {
		// TODO Auto-generated method stub
		return sir.findAll();
	}

	@Override
	public ServedItems saveServedItems(ServedItems si) {
		// TODO Auto-generated method stub
		return sir.save(si);
	}

	@Override
	public ServedItems findBySItem(String item) {
		// TODO Auto-generated method stub
		return sir.findByItem(item);
	}

	@Override
	public Boolean existsBySItem(String item) {
		// TODO Auto-generated method stub
		return sir.existsByItem(item);
	}

	@Override
	public int updateSItem(int qnty, int id) {
		// TODO Auto-generated method stub
		return sir.updateitem(qnty, id);
	}

	@Override
	public int itemUpdate(int qnty, int id) {
		// TODO Auto-generated method stub
		return ir.itemupdate(qnty, id);
	}
	
	
}
