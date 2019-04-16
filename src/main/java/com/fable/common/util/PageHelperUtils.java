package com.fable.common.util;

import com.github.pagehelper.PageHelper;

import java.util.Map;

/**
 * 分页辅助工具类
 */
public class PageHelperUtils {

    /**
     * 开始分页
     *
     * @param params 参数
     *               page 第几页
     *               size 每页几条数据
     */
    public static void startPage(Map<String, Object> params) {
        if (null == params) return;

        Integer pageNum = (Integer) params.get("page");
        Integer pageSize = (Integer) params.get("size");
        if (null != pageNum && null != pageSize && pageNum > 0 && pageSize > 0) {
            PageHelper.startPage(pageNum, pageSize);
        }
    }

}
