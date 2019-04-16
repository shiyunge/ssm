package com.fable.dataReceiver.task;


import com.fable.dataReceiver.bean.po.LocationDevicePO;
import com.fable.dataReceiver.enums.Constants;
import com.fable.dataReceiver.mapper.LocationDeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@EnableScheduling
public class LocationStatusTask {

    @Value("${task.location.enabled}")
    private boolean enabled;

    @Autowired
    private LocationDeviceMapper locationDeviceMapper;

    /**
     * 每1分钟执行一次
     *
     * @throws Exception 异常
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void execute() throws Exception {
        if (!enabled) {
            return;
        }
        Map<String, Object> params = new HashMap<>();
        List<LocationDevicePO> locationDevicePOList = locationDeviceMapper.selectByParams(params);
        for (LocationDevicePO locationDevicePO : locationDevicePOList) {
            if (System.currentTimeMillis() - locationDevicePO.getLastDataTime().getTime() > 6 * 60 * 1000) {
                locationDevicePO.setStatus(Constants.Status.OUT_LINE);
            } else {
                locationDevicePO.setStatus(Constants.Status.ON_LINE);
            }
            locationDeviceMapper.updateByPrimaryKeySelective(locationDevicePO);
        }
    }
}
