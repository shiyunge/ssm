package com.fable.dataReceiver.mapper;

import java.util.List;
import java.util.Map;

/**
 * 查询列表基类
 *
 * @param <T> 泛型参数
 * @author afeey
 */
public interface BaseSelectListMapper<T> {
    List<T> selectByParams(Map<String, Object> parms);
}
