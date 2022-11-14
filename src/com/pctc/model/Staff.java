package com.pctc.model;

import java.util.Date;

public class Staff {
  
	private Integer id;
	private String staffName;
	private Boolean sex;
	private Date birthday;
	private String nation;
	private String idCard;
	private String domicile;
	private Integer apartmentId;
	private Integer filetypeId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getDomicile() {
		return domicile;
	}
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	public Integer getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}
	public Integer getFiletypeId() {
		return filetypeId;
	}
	public void setFiletypeId(Integer filetypeId) {
		this.filetypeId = filetypeId;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", staffName=" + staffName + ", sex=" + sex + ", birthday=" + birthday + ", nation="
				+ nation + ", idCard=" + idCard + ", domicile=" + domicile + ", apartmentId=" + apartmentId
				+ ", filetypeId=" + filetypeId + "]";
	}
	public Staff(Integer id, String staffName, Boolean sex, Date birthday, String nation, String idCard,
			String domicile, Integer apartmentId, Integer filetypeId) {
		super();
		this.id = id;
		this.staffName = staffName;
		this.sex = sex;
		this.birthday = birthday;
		this.nation = nation;
		this.idCard = idCard;
		this.domicile = domicile;
		this.apartmentId = apartmentId;
		this.filetypeId = filetypeId;
	}
	public Staff() {
		
	}
}
