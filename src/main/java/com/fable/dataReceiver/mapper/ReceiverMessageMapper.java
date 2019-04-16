package com.fable.dataReceiver.mapper;


import com.fable.dataReceiver.bean.po.ReceiveMessagePO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * mapper层
 *
 * @author syg
 * @date 2019-3-19
 */
@Repository
public interface ReceiverMessageMapper extends BaseMapper<ReceiveMessagePO>, BaseSelectListMapper<ReceiveMessagePO> {


    /**
     * 根据设备编号去查询设备最新信息
     *
     * @param imei 设备编号
     * @return 设备对象
     */
    ReceiveMessagePO getByImei(String imei);


}
