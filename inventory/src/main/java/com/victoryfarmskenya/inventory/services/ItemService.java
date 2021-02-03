package com.victoryfarmskenya.inventory.services;

import java.util.List;
import java.util.Optional;

import com.victoryfarmskenya.inventory.models.Item;
import com.victoryfarmskenya.inventory.models.ItemRequest;
import com.victoryfarmskenya.inventory.models.Items;
import com.victoryfarmskenya.inventory.models.Locations;
import com.victoryfarmskenya.inventory.models.Purchases;
import com.victoryfarmskenya.inventory.models.ServedItems;
import com.victoryfarmskenya.inventory.models.ServedRequests;

public interface ItemService {

	List<Item> findAllItem();

	Item saveItem(Item item);

	Optional<Item> findItemById(int id);

	Item findByItem(String item);

	void deleteItem(int id);

	Boolean existsByItem(String item);

	List<ItemRequest> findAllRequest();

	ItemRequest saveRequest(ItemRequest item);

	Optional<ItemRequest> findItemRequestById(int id);

	void deleteItemRequest(int id);

	List<ServedRequests> findAllServedRequest();

	ServedRequests saveServedRequest(ServedRequests item);

	Optional<ServedRequests> findServedRequestById(int id);

	void deleteServedRequest(int id);

	List<Purchases> findAllPurchases();

	Purchases savePurchase(Purchases item);

	Purchases findPurchasesById(int id);

	void deletePurchases(int id);

	int updateItem(int qnty,int id);
	
	int itemUpdate(int qnty,int id);
	
	int updateComplete(int id);
	
	List<Items> findAllItems();
	
	Items saveItems(Items item);
	
    List<Locations> findAllLocations();
	
	Locations saveLocation(Locations location);
	
	List<ServedItems> getServedItems();
	
	ServedItems saveServedItems(ServedItems si);
	
	ServedItems findBySItem(String item);

	Boolean existsBySItem(String item);

	int updateSItem(int qnty,int id);
}
