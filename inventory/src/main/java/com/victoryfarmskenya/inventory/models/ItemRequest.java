package com.victoryfarmskenya.inventory.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
public @Data class ItemRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int qnty;
	@Column
	private String item;
	@Column
	private String requester;
	@Column
	private String location;
	@Column
	private boolean complete;
	@Column
	private String reqdate;
	@Column
	private String comments;
	
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getRequester() {
		return requester;
	}
	public void setRequester(String requester) {
		this.requester = requester;
	}
	public String getReqdate() {
		return reqdate;
	}
	public void setReqdate(String reqdate) {
		this.reqdate = reqdate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
