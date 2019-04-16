package com.fable.dataReceiver.service;

import com.fable.dataReceiver.bean.po.LocationDevicePO;

import java.util.List;
import java.util.Map;

public interface ContentService {

    List<LocationDevicePO> getContentList(Map<String, Object> params);

    LocationDevicePO get(String imei) throws Exception;

    Map<String, Object> map();

}
