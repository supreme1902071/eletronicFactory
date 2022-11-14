package com.pctc.vo;

import java.util.Date;

public class LendVo {    
	private Integer id;
    private String number;
    private Integer  year;
    private String fileName;
    private Date lendTime;
    private Date returnTime;
    private Boolean flag;
    private String apartmentName;
    private String lender;

    public LendVo() {
    }
    public LendVo(Integer id, String number, Integer  year, String fileName, Date lendTime, Date returnTime, Boolean flag, String apartmentName, String lender) {
        this.id=id;
        this.number=number;
        this. year=year;
        this.fileName=fileName;
        this.lendTime=lendTime;
        this.returnTime=returnTime;
        this.flag=flag;
        this.apartmentName=apartmentName;
        this.lender=lender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer  year) {
        this.year =  year;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public void setLendTime(Date lendTime) {
        this.lendTime = lendTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

   

    public String getLender() {
        return lender;
    }

    public void setLender(String lender) {
        this.lender = lender;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", year=" + year +
                ", fileName='" + fileName + '\'' +
                ", lendTime=" + lendTime +
                ", returnTime=" + returnTime +
                ", flag=" + flag +
                ", apartmentName=" + apartmentName +
                ", lender='" + lender + '\'' +
                '}';
    }
}
