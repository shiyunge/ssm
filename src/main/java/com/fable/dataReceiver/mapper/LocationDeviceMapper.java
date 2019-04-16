package com.fable.dataReceiver.mapper;

import com.fable.dataReceiver.bean.po.LocationDevicePO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface LocationDeviceMapper extends BaseMapper<LocationDevicePO>, BaseSelectListMapper<LocationDevicePO> {

    LocationDevicePO getByImei(String imei);

}
