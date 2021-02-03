package com.victoryfarmskenya.inventory.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table
public @Data class ServedRequests{
	
	@Id
	@Column
	private int id;
	@Column
	private int qnty;
	@Column
	private String item;
	@Column
	private String requester;
	@Column
	private String servedby;
	@Column
	private String reqdate;
	@Column
	private String location;
	@Column
	private String servedate;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getServedby() {
		return servedby;
	}
	public void setServedby(String servedby) {
		this.servedby = servedby;
	}
	public String getReqdate() {
		return reqdate;
	}
	public void setReqdate(String reqdate) {
		this.reqdate = reqdate;
	}
	public String getServedate() {
		return servedate;
	}
	public void setServedate(String servedate) {
		this.servedate = servedate;
	}
	
}
