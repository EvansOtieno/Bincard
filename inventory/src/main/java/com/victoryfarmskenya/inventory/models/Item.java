package com.victoryfarmskenya.inventory.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table
@Inheritance(strategy =InheritanceType.JOINED)
public @Data class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String unitprice;
	@Column
	private int qnty;
	@Column
	private String item;
	@Column
	private String Extension;
	@Column
	private String description;
	@Column
	private String location;
	@Column
	@Lob
	private byte[] picture;
	@Transient
	private String base64image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}
	public int getQnty() {
		return qnty;
	}
	public void setQnty(int qnty) {
		this.qnty = qnty;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public String getExtension() {
		return Extension;
	}
	public void setExtension(String extension) {
		Extension = extension;
	}
	public String getBase64image() {
		return base64image;
	}
	public void setBase64image(String base64image) {
		this.base64image = base64image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
