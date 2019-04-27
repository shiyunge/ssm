package com.fable.dataReceiver.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.fable.dataReceiver.Redis.JedisClientSingle;
import com.fable.dataReceiver.bean.po.LocationDevicePO;
import com.fable.dataReceiver.service.ContentService;
import com.fable.dataReceiver.service.LocationDeviceService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private JedisClientSingle jedisClientSingle;

    @Autowired
    private LocationDeviceService locationDeviceService;


    /**
     * java中存储list集合方式   可能导致的就是数据的同步性比较差
     *
     * @param params 查询条件
     * @return 列表
     */
    @Override
    public List<LocationDevicePO> getContentList(Map<String, Object> params) {
        String str = jedisClientSingle.get("list");
        List<LocationDevicePO> locationDevicePOS = new ArrayList<>();
        if (Strings.isNullOrEmpty(str)) {
            //redis数据库没有缓存
            locationDevicePOS = locationDeviceService.query(params).getList();
            //存储缓存
            jedisClientSingle.set("list", JSONArray.toJSONString(locationDevicePOS));
            return null;
        } else {
            //字符串转集合
            List<LocationDevicePO> locationDevicePOS1 = JSONArray.parseArray(jedisClientSingle.get("list"), LocationDevicePO.class);
            return locationDevicePOS1;
        }
    }

    /**
     * java中存储对象的redis
     *
     * @param imei 设备编号
     * @return 对象
     */
    @Override
    public LocationDevicePO get(String imei) throws Exception {
        String str = jedisClientSingle.get("OBJECT");
        if (Strings.isNullOrEmpty(str)) {
            LocationDevicePO record = locationDeviceService.getByImei(imei);
            jedisClientSingle.set("OBJECT", JSONArray.toJSONString(record));
            return null;
        } else {
            LocationDevicePO record = JSONArray.parseObject(str, LocationDevicePO.class);
            return record;
        }
    }

    /**
     * 讲map对象存储到redis数据库中
     *
     * @return map
     */
    @Override
    public Map<String, Object> map() {
        String str = jedisClientSingle.get("MAP");
        if (Strings.isNullOrEmpty(str)) {
            Map<String, Object> params = new HashMap<>();
            params.put("1", "测试一");
            params.put("2", "测试二");
            jedisClientSingle.set("MAP", JSONArray.toJSONString(params));
            return null;
        } else {
            Map<String, Object> record = JSONArray.parseObject(str, Map.class);
            return record;
        }
    }

public static void main(String[]args){

User user = new User();
    user.setName("数");
    System.out.println(obj2Map(user));
    System.out.println(obj2Map(user).get("name"));

}

    private static Map<String, String> obj2Map(Object obj) {
        Map<String, String> map = new HashMap<String, String>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String varName = fields[i].getName();
            varName = varName.toLowerCase();
            boolean accessFlag = fields[i].isAccessible();
            fields[i].setAccessible(true);
            try {
                Object object = fields[i].get(obj);
                if (object != null)
                    map.put(varName, object.toString());

                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }



}
