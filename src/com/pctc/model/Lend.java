package com.pctc.model;

import java.util.Date;

public class Lend {
    private Integer id;
    private String number;
    private Integer  year;
    private String fileName;
    private Date lendTime;
    private Date returnTime;
    private Boolean flag;
    private Integer apartmentId;
    private String lender;

    public Lend() {
    }
    public Lend(Integer id, String number, Integer year, String fileName, Date lendTime, Date returnTime, Boolean flag, Integer apartmentId, String lender) {
        this.id=id;
        this.number=number;
        this.year=year;
        this.fileName=fileName;
        this.lendTime=lendTime;
        this.returnTime=returnTime;
        this.flag=false;
        this.apartmentId=apartmentId;
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

    public void setYear(Integer year) {
        this.year = year;
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

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
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
                ", apartmentId=" + apartmentId +
                ", lender='" + lender + '\'' +
                '}';
    }
}
