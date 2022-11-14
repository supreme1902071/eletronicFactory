package com.pctc.vo;

public class FilesVo {
    private Integer id;
    private Integer year;
    private String number;
    private String fileName;
    private String register;
    private String position;
    private String apartmentName;
    private String filetypeName;
    private String securitylevelName;
    private String keeperName;

    public FilesVo(Integer id, Integer year, String number, String fileName, String register, String position, String apartmentName, String filetypeName, String securitylevelName, String keeperName) {
        this.id = id;
        this.year = year;
        this.number = number;
        this.fileName = fileName;
        this.register = register;
        this.position = position;
        this.apartmentName = apartmentName;
        this.filetypeName = filetypeName;
        this.securitylevelName = securitylevelName;
        this.keeperName = keeperName;
    }

    public FilesVo() {
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



    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getFiletypeName() {
        return filetypeName;
    }

    public void setFiletypeName(String filetypeName) {
        this.filetypeName = filetypeName;
    }

    public String getSecuritylevelName() {
        return securitylevelName;
    }

    public void setSecuritylevelName(String securitylevelName) {
        this.securitylevelName = securitylevelName;
    }

    public String getKeeperName() {
        return keeperName;
    }

    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName;
    }

    @Override
    public String toString() {
        return "FilesVo{" +
                "id=" + id +
                ", year=" + year +
                ", number='" + number + '\'' +
                ", fileName='" + fileName + '\'' +
                ", register='" + register + '\'' +
                ", position='" + position + '\'' +
                ", apartmentName='" + apartmentName + '\'' +
                ", filetypeName='" + filetypeName + '\'' +
                ", securitylevelName='" + securitylevelName + '\'' +
                ", keeperName='" + keeperName + '\'' +
                '}';
    }
}
