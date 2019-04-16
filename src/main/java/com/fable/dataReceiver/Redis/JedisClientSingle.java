package com.fable.dataReceiver.Redis;

import com.fable.dataReceiver.util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @author syg
 * @date 2019-4-15
 */
@Component
public class JedisClientSingle implements JedisClient {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.get(key);
        //执行完需要关闭对应的流
        jedis.close();
        return str;
    }

    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.set(key, value);
        jedis.close();
        return str;
    }

    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.hget(hkey, key);
        jedis.close();
        return string;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(hkey, key, value);
        jedis.close();
        return result;
    }

    @Override
    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    @Override
    public long expire(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, second);
        jedis.close();
        return result;
    }

    @Override
    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    @Override
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    @Override
    public long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;
    }

    @Override
    public void setList(String key, List<?> list) {
        Jedis jedis = jedisPool.getResource();
        try {
            if (list == null || list.size() == 0) {
                jedis.set(key.getBytes(), "".getBytes());
            } else {//如果list为空,则设置一个空
                jedis.set(key.getBytes(), SerializeUtil.serializeList(list));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    /**
     * 获取List集合
     *
     * @param key
     * @return
     */
    @Override
    public List<?> getList(String key) {
        Jedis jedis = jedisPool.getResource();
        if (jedis == null || !jedis.exists(key)) {
            return null;
        }
        byte[] data = jedis.get(key.getBytes());
        jedis.close();
        return SerializeUtil.unserializeList(data);
    }


}
