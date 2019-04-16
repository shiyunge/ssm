package com.fable.common.bean.vo;

/**
 * 结果类
 *
 * @author afeey
 */
public class Result {

    /**
     * 成功状态
     */
    protected boolean success;

    /**
     * 结果编码，200表示成功
     */
    protected String code;

    /**
     * 提示消息
     */
    protected String message;

    /**
     * 异常信息
     */
    private String error;

    /**
     * 构造函数
     */
    public Result() {
        this(true, "200", "执行成功");
    }

    /**
     * 构造函数
     *
     * @param success 成功状态
     * @param code    结果编码，200表示成功
     * @param message 提示消息
     */
    public Result(boolean success, String code, String message) {
        this(success, code, message, null);
    }

    /**
     * 构造函数
     *
     * @param success 成功状态
     * @param code    结果编码，200表示成功
     * @param message 提示消息
     * @param error   异常信息
     */
    public Result(boolean success, String code, String message, String error) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}