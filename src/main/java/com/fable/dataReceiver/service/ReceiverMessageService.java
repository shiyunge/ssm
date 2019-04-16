package com.fable.dataReceiver.service;

import com.fable.dataReceiver.bean.po.ReceiveMessagePO;

import java.util.List;
import java.util.Map;

/**
 * @author syg
 * @date 2019-3-19
 */
public interface ReceiverMessageService {

    /**
     * 添加定位数据的接口
     *
     * @param record 对象
     * @return 对象
     * @throws Exception 异常
     */
    ReceiveMessagePO add(ReceiveMessagePO record) throws Exception;


    /**
     * 根据设备编码去查询设备的最新信息
     *
     * @param imei 设备编码
     * @return 设备信息对象
     * @throws Exception 异常
     */

    ReceiveMessagePO getByImei(String imei) throws Exception;


    /**
     * 条件查询人员定位记录
     *
     * @param params 查询条件
     * @return 列表
     * @throws Exception 异常
     */
    List<ReceiveMessagePO> queryList(Map<String, Object> params) throws Exception;


}
