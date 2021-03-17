package com.xuemiao.taosmybaits.sqlserver.domain;

import java.sql.Timestamp;

/**
 * @author xxm
 * @date 2021/3/10 13:39
 */
public class HistoryData {

    private Long ts;
    private Integer deviceId;
    private String json;
    private Boolean isOfflineData;

    public HistoryData() {
    }

    public HistoryData(Long ts, Integer deviceId, String json, Boolean isOfflineData) {
        this.ts = ts;
        this.deviceId = deviceId;
        this.json = json;
        this.isOfflineData = isOfflineData;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public Boolean getOfflineData() {
        return isOfflineData;
    }

    public void setOfflineData(Boolean offlineData) {
        isOfflineData = offlineData;
    }
}
