package org.spring.springboot.domain;

import java.util.Date;

/**
 * Created by michael on 2017/8/9.
 */
public class TParkInfoCluster {
    private String parkid;//停车场编号
    private String name;//停车场名称
    private String allnumber;//全部车位数
    private String occupiednumber;//占用车位数
    private String schedulenumber;//预留车位数
    private String freenumber;//空余车位
    private String unitname;//牌号码
    private String telephone;// 联系电话
    private Integer administrator;//管理员
    private String address;//地址
    private String areas;//所属辖区
    private Date updatetime;//更新时间 （ 例如 2016-09-08 12:21:33）
    private String longitude;//经度
    private String latitude;//纬度

    private String startDateStr;//查询开始实际
    private String endDateStr;//查询结束实际

    public String getParkid() {
        return this.parkid;
    }

    public void setParkid(String parkid) {
        this.parkid = parkid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllnumber() {
        return this.allnumber;
    }

    public void setAllnumber(String allnumber) {
        this.allnumber = allnumber;
    }

    public String getOccupiednumber() {
        return this.occupiednumber;
    }

    public void setOccupiednumber(String occupiednumber) {
        this.occupiednumber = occupiednumber;
    }

    public String getSchedulenumber() {
        return this.schedulenumber;
    }

    public void setSchedulenumber(String schedulenumber) {
        this.schedulenumber = schedulenumber;
    }

    public String getFreenumber() {
        return this.freenumber;
    }

    public void setFreenumber(String freenumber) {
        this.freenumber = freenumber;
    }

    //    public Integer getAllnumber() {
//        return this.allnumber;
//    }
//
//    public void setAllnumber(Integer allnumber) {
//        this.allnumber = allnumber;
//    }
//
//    public Integer getOccupiednumber() {
//        return this.occupiednumber;
//    }
//
//    public void setOccupiednumber(Integer occupiednumber) {
//        this.occupiednumber = occupiednumber;
//    }
//
//    public Integer getSchedulenumber() {
//        return this.schedulenumber;
//    }
//
//    public void setSchedulenumber(Integer schedulenumber) {
//        this.schedulenumber = schedulenumber;
//    }
//
//    public Integer getFreenumber() {
//        return this.freenumber;
//    }
//
//    public void setFreenumber(Integer freenumber) {
//        this.freenumber = freenumber;
//    }

    public String getUnitname() {
        return this.unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getAdministrator() {
        return this.administrator;
    }

    public void setAdministrator(Integer administrator) {
        this.administrator = administrator;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreas() {
        return this.areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getStartDateStr() {
        return this.startDateStr;
    }

    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getEndDateStr() {
        return this.endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }
}
