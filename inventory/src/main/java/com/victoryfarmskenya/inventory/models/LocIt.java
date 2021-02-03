package com.victoryfarmskenya.inventory.models;

import java.util.List;

public class LocIt {
	List<Items> items;
	List<Locations> locations;
	public LocIt(List<Items> items, List<Locations> locations) {
		this.items=items;
		this.locations=locations;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public List<Locations> getLocations() {
		return locations;
	}
	public void setLocations(List<Locations> locations) {
		this.locations = locations;
	}
	
	
}
