package com.fable.dataReceiver.Redis;

import java.util.List;

/**
 * @author syg
 * @date 2019-4-15
 */
public interface JedisClient {

    String get(String key); //读取数据

    String set(String key, String value);//向redis中写入数据

    String hget(String hkey, String key);//获取存储结构是hashMap类型的操作

    long hset(String hkey, String key, String value);

    long incr(String key);

    long expire(String key, int second);//设置生存时间

    long ttl(String key);

    long del(String key); //删除数据

    long hdel(String hkey, String key);

    public void setList(String key, List<?> list);

    public List<?> getList(String key);


}
