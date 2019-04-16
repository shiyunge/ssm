package com.fable.dataReceiver.service.Impl;

import com.fable.common.exception.BusinessException;
import com.fable.dataReceiver.bean.po.ReceiveMessagePO;
import com.fable.dataReceiver.mapper.ReceiverMessageMapper;
import com.fable.dataReceiver.service.ReceiverMessageService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 定位记录业务层
 *
 * @author syg
 * @date 2019-4-10
 */
@Service
public class ReceiverMessageServiceImpl implements ReceiverMessageService {

    @Autowired
    private ReceiverMessageMapper receiverMessageMapper;

    @Override
    public ReceiveMessagePO add(ReceiveMessagePO record) throws Exception {
        receiverMessageMapper.insertSelective(record);
        return record;
    }

    @Override
    public ReceiveMessagePO getByImei(String imei) throws Exception {
        if (Strings.isNullOrEmpty(imei)) {
            throw new BusinessException("500", "定位设备编号不能为空");
        }
        return receiverMessageMapper.getByImei(imei);
    }

    @Override
    public List<ReceiveMessagePO> queryList(Map<String, Object> params) throws Exception {
        return receiverMessageMapper.selectByParams(params);
    }


}
