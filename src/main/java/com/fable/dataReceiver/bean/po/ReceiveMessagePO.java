package com.fable.dataReceiver.bean.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Table;

/**
 * 接受客户端的信息
 *
 * @author syg
 * @date 2019-3-15
 */

@ApiModel(value = "人员定位PO")
@Table(name = "lm_message")
public class ReceiveMessagePO extends BasePO {

    @ApiModelProperty(value = "主键")
    private String id;

    @ApiModelProperty(value = "设备Id")
    private String deviceId;

    @ApiModelProperty(value = "消息Id")
    private String messageId;

    @ApiModelProperty(value = "消息流水号")
    private String megSeq;

    @ApiModelProperty(value = "消息长度")
    private String messageLength;

    @ApiModelProperty(value = "信号强度")
    private String signalStrengths;

    @ApiModelProperty(value = "上报间隔")
    private String reportInterval;

    @ApiModelProperty(value = "运动状态")
    private String moveStatus;

    @ApiModelProperty(value = "按键报警")
    private String buttonAlarm;

    @ApiModelProperty(value = "设备电量")
    private String deviceBattery;

    @ApiModelProperty(value = "GPS定位模式")
    private String locationMode;

    @ApiModelProperty(value = "定位状态")
    private String locationStatus;

    @ApiModelProperty(value = "定位耗时")
    private String locationTime;

    @ApiModelProperty(value = "配置发送间隔")
    private String configInterval;

    @ApiModelProperty(value = "配置gSensor使能")
    private String configEnabled;

    @ApiModelProperty(value = "GPS定位超时时长")
    private String positionTimeout;

    @ApiModelProperty(value = "校验码")
    private String checkCode;

    @ApiModelProperty(value = "百度经度")
    private Double batLng;

    @ApiModelProperty(value = "百度维度")
    private Double batLat;


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
}
