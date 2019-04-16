package com.fable.common.bean.vo;

/**
 * 对象结果类
 *
 * @author afeey
 */
public class ObjectResult<E> extends Result {

    /**
     * 数据列表
     */
    private E data = null;

    /**
     * 构造函数
     */
    public ObjectResult() {
        super();
    }

    /**
     * 构造函数
     *
     * @param success 成功状态
     * @param code    结果编码，200表示成功
     * @param message 提示消息
     * @param data    数据对象
     */
    public ObjectResult(boolean success, String code, String message, E data) {
        super(success, code, message);
        this.data = data;
    }

    /**
     * 构造函数
     *
     * @param success 成功状态
     * @param code    结果编码，200表示成功
     * @param message 提示消息
     * @param error   异常信息
     */
    public ObjectResult(boolean success, String code, String message, String error) {
        super(success, code, message, error);
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}