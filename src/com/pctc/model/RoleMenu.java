package com.pctc.model;

public class RoleMenu {
	
	private Integer id;
	private Integer roleId;
	private Integer menuId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public RoleMenu(Integer id, Integer roleId, Integer menuId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
	}
	
	public RoleMenu() {
	
	}
	@Override
	public String toString() {
		return "RoleMenu [id=" + id + ", roleId=" + roleId + ", menuId=" + menuId + "]";
	}
	
}
