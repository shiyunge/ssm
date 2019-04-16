package com.fable.dataReceiver.service;


import com.fable.dataReceiver.bean.po.LocationDevicePO;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface LocationDeviceService {


    /**
     * 根据设备编码去查询设备的最新信息
     *
     * @param imei 设备编码
     * @return 设备信息对象
     * @throws Exception 异常
     */

    LocationDevicePO getByImei(String imei) throws Exception;


    /**
     * 多条件查询
     *
     * @param params
     * @return
     */
    PageInfo<LocationDevicePO> query(Map<String, Object> params);

}
