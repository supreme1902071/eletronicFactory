package com.pctc.model;

public class Menu {
	private Integer id;
	private String menuName;
	private String url;
	public Menu(Integer id, String menuName, String url) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.url = url;
	}
	
	
	public Menu() {
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + ", url=" + url + "]";
	}
	
	

}
