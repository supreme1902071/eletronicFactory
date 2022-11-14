package com.pctc.model;

public class Apartment {
	private Integer id;
	private String apartmentName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public Apartment(Integer id, String apartmentName) {
		super();
		this.id = id;
		this.apartmentName = apartmentName;
	}
	public Apartment() {
		super();
	}
	@Override
	public String toString() {
		return "Apartment [id=" + id + ", apartmentName=" + apartmentName + "]";
	}
	

}
