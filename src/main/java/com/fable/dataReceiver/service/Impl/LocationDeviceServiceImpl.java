package com.fable.dataReceiver.service.Impl;

import com.fable.common.util.PageHelperUtils;
import com.fable.dataReceiver.bean.po.LocationDevicePO;
import com.fable.dataReceiver.mapper.LocationDeviceMapper;
import com.fable.dataReceiver.service.LocationDeviceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LocationDeviceServiceImpl implements LocationDeviceService {

    @Autowired
    private LocationDeviceMapper locationDeviceMapper;

    @Override
    public LocationDevicePO getByImei(String imei) throws Exception {
        return locationDeviceMapper.getByImei(imei);
    }

    @Override
    public PageInfo<LocationDevicePO> query(Map<String, Object> params) {
        PageHelperUtils.startPage(params);
        return new PageInfo<>(locationDeviceMapper.selectByParams(params));
    }
}
