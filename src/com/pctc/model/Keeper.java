package com.pctc.model;

public class Keeper {
	private int id ;
	private String keeperName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeeperName() {
		return keeperName;
	}
	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}
	public Keeper(int id, String keeperName) {
		super();
		this.id = id;
		this.keeperName = keeperName;
	}
	public Keeper() {
		super();
	}
	@Override
	public String toString() {
		return "Keeper [id=" + id + ", keeperName=" + keeperName + "]";
	}
	
}
