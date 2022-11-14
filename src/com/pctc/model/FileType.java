package com.pctc.model;

public class FileType {
	private int id;
	private String fileType;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public FileType(int id, String fileType) {
		super();
		this.id = id;
		this.fileType = fileType;
	}
	
	public FileType(){
		
	}
	@Override
	public String toString() {
		return "FileType [id=" + id + ", fileType=" + fileType + "]";
	}
	

}
