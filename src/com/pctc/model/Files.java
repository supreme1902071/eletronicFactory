package com.pctc.model;

public class Files {
    private Integer id;
    private Integer year;
    private String number;
    private String fileName;
    private String register;
    private String position;
    private Integer apartmentId;
    private Integer filetypeId;
    private Integer securitylevelId;
    private Integer keeperId;

    public Files(Integer id, Integer year, String number, String fileName, String register, String position, Integer apartmentId, Integer filetypeId, Integer securitylevelId, Integer keeperId) {
        this.id = id;
        this.year = year;
        this.number = number;
        this.fileName = fileName;
        this.register = register;
        this.position = position;
        this.apartmentId = apartmentId;
        this.filetypeId = filetypeId;
        this.securitylevelId = securitylevelId;
        this.keeperId = keeperId;
    }

    public Files(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public Integer getSecuritylevelId() {
        return securitylevelId;
    }

    public void setSecuritylevelId(Integer securitylevelId) {
        this.securitylevelId = securitylevelId;
    }

    public Integer getKeeperId() {
        return keeperId;
    }

    public void setKeeperId(Integer keeperId) {
        this.keeperId = keeperId;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", year=" + year +
                ", number='" + number + '\'' +
                ", fileName='" + fileName + '\'' +
                ", register='" + register + '\'' +
                ", position='" + position + '\'' +
                ", apartmentId=" + apartmentId +
                ", filetypeId=" + filetypeId +
                ", securitylevelId=" + securitylevelId +
                ", keeperId=" + keeperId +
                '}';
    }
}
