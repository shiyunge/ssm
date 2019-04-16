package com.fable.dataReceiver.bean.po;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "lm_location_device")
public class LocationDevicePO {

    @Id
    private String id;

    private String deviceId;

    private String messageId;

    private String megSeq;

    private String messageLength;

    private String signalStrengths;

    private String reportInterval;

    private String moveStatus;

    private String buttonAlarm;

    private String deviceBattery;

    private String locationMode;

    private String locationStatus;

    private String locationTime;

    private String configInterval;

    private String configEnabled;

    private String positionTimeout;

    private String checkCode;

    private Double batLng;

    private Double batLat;

    private Date lastDataTime;

    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMegSeq() {
        return megSeq;
    }

    public void setMegSeq(String megSeq) {
        this.megSeq = megSeq;
    }

    public String getMessageLength() {
        return messageLength;
    }

    public void setMessageLength(String messageLength) {
        this.messageLength = messageLength;
    }

    public String getSignalStrengths() {
        return signalStrengths;
    }

    public void setSignalStrengths(String signalStrengths) {
        this.signalStrengths = signalStrengths;
    }

    public String getReportInterval() {
        return reportInterval;
    }

    public void setReportInterval(String reportInterval) {
        this.reportInterval = reportInterval;
    }

    public String getMoveStatus() {
        return moveStatus;
    }

    public void setMoveStatus(String moveStatus) {
        this.moveStatus = moveStatus;
    }

    public String getButtonAlarm() {
        return buttonAlarm;
    }

    public void setButtonAlarm(String buttonAlarm) {
        this.buttonAlarm = buttonAlarm;
    }

    public String getDeviceBattery() {
        return deviceBattery;
    }

    public void setDeviceBattery(String deviceBattery) {
        this.deviceBattery = deviceBattery;
    }

    public String getLocationMode() {
        return locationMode;
    }

    public void setLocationMode(String locationMode) {
        this.locationMode = locationMode;
    }

    public String getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(String locationStatus) {
        this.locationStatus = locationStatus;
    }

    public String getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(String locationTime) {
        this.locationTime = locationTime;
    }

    public String getConfigInterval() {
        return configInterval;
    }

    public void setConfigInterval(String configInterval) {
        this.configInterval = configInterval;
    }

    public String getConfigEnabled() {
        return configEnabled;
    }

    public void setConfigEnabled(String configEnabled) {
        this.configEnabled = configEnabled;
    }

    public String getPositionTimeout() {
        return positionTimeout;
    }

    public void setPositionTimeout(String positionTimeout) {
        this.positionTimeout = positionTimeout;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public Double getBatLng() {
        return batLng;
    }

    public void setBatLng(Double batLng) {
        this.batLng = batLng;
    }

    public Double getBatLat() {
        return batLat;
    }

    public void setBatLat(Double batLat) {
        this.batLat = batLat;
    }

    public Date getLastDataTime() {
        return lastDataTime;
    }

    public void setLastDataTime(Date lastDataTime) {
        this.lastDataTime = lastDataTime;
    }
}
