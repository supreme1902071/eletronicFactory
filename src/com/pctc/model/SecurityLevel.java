package com.pctc.model;

public class SecurityLevel {
	private int id ;
	private String securityLevel;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSecurityLevel() {
		return securityLevel;
	}
	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}
	public SecurityLevel() {
		super();
	}
	public SecurityLevel(int id, String securityLevel) {
		super();
		this.id = id;
		this.securityLevel = securityLevel;
	}
	@Override
	public String toString() {
		return "SecurityLevel [id=" + id + ", securityLevel=" + securityLevel + "]";
	}
	

}
