package com.xuemiao.taosmybaits.taos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

/**
 * @author xxm
 * @date 2021/3/9 14:18
 */

public class Stack {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Integer id;
    private Timestamp ts;
    private Integer s1;
    private Integer s2;
    private Integer s3;
    private Integer areaid;
    private Integer projectid;
    private Integer cityid;
    private String address;


    public Stack() {
    }

    public Stack(Integer id, Timestamp ts, Integer s1, Integer s2, Integer s3, Integer areaid, Integer projectid, Integer cityid, String address) {
        this.id = id;
        this.ts = ts;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.areaid = areaid;
        this.projectid = projectid;
        this.cityid = cityid;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }

    public Integer getS1() {
        return s1;
    }

    public void setS1(Integer s1) {
        this.s1 = s1;
    }

    public Integer getS2() {
        return s2;
    }

    public void setS2(Integer s2) {
        this.s2 = s2;
    }

    public Integer getS3() {
        return s3;
    }

    public void setS3(Integer s3) {
        this.s3 = s3;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "id=" + id +
                ", ts=" + ts +
                ", s1=" + s1 +
                ", s2=" + s2 +
                ", s3=" + s3 +
                ", areaid=" + areaid +
                ", projectid=" + projectid +
                ", cityid=" + cityid +
                ", address='" + address + '\'' +
                '}';
    }
}
