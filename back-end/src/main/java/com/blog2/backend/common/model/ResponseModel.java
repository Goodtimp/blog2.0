package com.blog2.backend.common.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: goodtimp
 * @Date: 2019/10/10 14:44
 * @description :  响应模板
 */
public class ResponseModel {
    private static final int SUCCESS_CODE = 200;
    private static final String SUCCESS_MSG = "操作成功！";
    private static final int FAIL_CODE = 1;
    private static final String FAIL_MSG = "操作失败！";

    private int code;
    private String msg;
    private Map<String, Object> extend = new HashMap<>();

    public int getCode() {
        return this.code;
    }

    public void setCode(int value) {
        this.code = value;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String value) {
        this.msg = value;
    }

    public Map<String, Object> setExtend() {
        return this.extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

    /**
     * 成功操作 默认提示
     *
     * @return
     */
    public static ResponseModel success() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(SUCCESS_CODE);
        responseModel.setMsg(SUCCESS_MSG);
        return responseModel;
    }

    /**
     * 成功操作 修改提示
     *
     * @param msg
     * @return
     */
    public static ResponseModel success(String msg) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(SUCCESS_CODE);
        responseModel.setMsg(msg);
        return responseModel;
    }

    /**
     * 成功操作 指定extend
     *
     * @param value
     * @return
     */
    public static ResponseModel success(Map<String, Object> value) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(SUCCESS_CODE);
        responseModel.setMsg(SUCCESS_MSG);
        responseModel.setExtend(value);
        return responseModel;
    }

    /**
     * 成功操作，增加extend的一个key value
     *
     * @param key
     * @param value
     * @return
     */
    public static ResponseModel success(String key, Object value) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(SUCCESS_CODE);
        responseModel.setMsg(SUCCESS_MSG);
        responseModel.extend.put(key, value);
        return responseModel;
    }

    /**
     * 失败操作 默认提示
     *
     * @return
     */
    public static ResponseModel fail() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(FAIL_CODE);
        responseModel.setMsg(FAIL_MSG);
        return responseModel;
    }

    /**
     * 失败操作 默认提示
     *
     * @param code 错误代码
     * @return
     */
    public static ResponseModel fail(int code) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(code);
        responseModel.setMsg(FAIL_MSG);
        return responseModel;
    }

    /**
     * 失败操作 默认提示
     *
     * @param code 错误代码
     * @param msg  错误信息
     * @return
     */
    public static ResponseModel fail(int code, String msg) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(code);
        responseModel.setMsg(msg);
        return responseModel;
    }

    /**
     * 失败操作 指定msg
     *
     * @param msg
     * @return
     */
    public static ResponseModel fail(String msg) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(FAIL_CODE);
        responseModel.setMsg(msg);
        return responseModel;
    }

    /**
     * 失败操作 设置extend 值
     *
     * @param value
     * @return
     */
    public static ResponseModel fail(Map<String, Object> value) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(FAIL_CODE);
        responseModel.setMsg(FAIL_MSG);
        responseModel.setExtend(value);
        return responseModel;
    }

    /**
     * 失败操作，增加一个extend传入的值
     *
     * @param value
     * @return
     */
    public static ResponseModel fail(String key, Object value) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(FAIL_CODE);
        responseModel.setMsg(FAIL_MSG);
        responseModel.extend.put(key, value);
        return responseModel;
    }


    /**
     * 添加一个extend  调用时应先调用 该类内 某个静态方法 方法
     *
     * @param key
     * @param value
     * @return
     */
    public ResponseModel addExtend(String key, Object value) {
        this.extend.put(key, value);
        return this;
    }

    /**
     * 将value加入extend   调用时应先调用 该类内 静态方法 方法
     *
     * @param value
     * @return
     */
    public ResponseModel addExtend(Map<String, Object> value) {
        this.extend.putAll(value);
        return this;
    }

    /**
     * 添加一个msg  调用时应先调用 该类内 静态方法 方法
     *
     * @param key
     * @param value
     * @return
     */
    public ResponseModel addMsg(String msg) {
        this.setMsg(msg);
        return this;
    }
}
