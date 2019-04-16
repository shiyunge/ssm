package com.fable.common.bean.vo;

import java.util.List;

/**
 * 列表结果类
 *
 * @author afeey
 */
public class ListResult<E> extends Result {

    /**
     * 当前页码
     */
    private long page;

    /**
     * 记录总数
     */
    private long total;

    /**
     * 数据列表
     */
    private List<E> data;

    public ListResult() {
    }

    /**
     * 构造函数
     *
     * @param success 成功状态
     * @param code    结果代码，200表示成功
     * @param message 消息提示
     * @param data    数据列表
     */
    public ListResult(boolean success, String code, String message, List<E> data) {
        super(success, code, message, null);
        this.data = data;
    }

    /**
     * 构造函数
     *
     * @param success 成功状态
     * @param code    结果代码，200表示成功
     * @param message 消息提示
     * @param page    当前页码
     * @param total   总记录数
     * @param data    数据列表
     */
    public ListResult(boolean success, String code, String message, long page, long total, List<E> data) {
        super(success, code, message, null);
        this.page = page;
        this.total = total;
        this.data = data;
    }

    /**
     * 构造函数
     *
     * @param success 成功状态
     * @param code    结果代码，200表示成功
     * @param message 消息提示
     * @param error   异常信息
     */
    public ListResult(boolean success, String code, String message, String error) {
        super(success, code, message, error);
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}