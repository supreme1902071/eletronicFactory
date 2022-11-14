package com.pctc.model;

import java.util.Date;

public class Upload {

	private int id;
	private String filename;
	private String username;
	private Date uploadtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}
	public Upload(int id, String filename, String username, Date uploadtime) {
		super();
		this.id = id;
		this.filename = filename;
		this.username = username;
		this.uploadtime = uploadtime;
	}
	public Upload() {
		super();
	}
	@Override
	public String toString() {
		return "Upload [id=" + id + ", filename=" + filename + ", username=" + username + ", uploadtime=" + uploadtime
				+ "]";
	}
	
	
	
}
