package com.pctc.model;

import java.util.Date;

public class Visit {
	private Integer id;
	private String ip;
	private String userName;
	private Date visitTime;
	private String visitServlet;
	private String parameter;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public String getVisitServlet() {
		return visitServlet;
	}
	public void setVisitServlet(String visitServlet) {
		this.visitServlet = visitServlet;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public Visit(Integer id, String ip, String userName, Date visitTime, String visitServlet, String parameter) {
		super();
		this.id = id;
		this.ip = ip;
		this.userName = userName;
		this.visitTime = visitTime;
		this.visitServlet = visitServlet;
		this.parameter = parameter;
	}
	public Visit() {
		super();
	}
	@Override
	public String toString() {
		return "Visit [id=" + id + ", ip=" + ip + ", userName=" + userName + ", visitTime=" + visitTime
				+ ", visitServlet=" + visitServlet + ", parameter=" + parameter + "]";
	}
	
	
}
