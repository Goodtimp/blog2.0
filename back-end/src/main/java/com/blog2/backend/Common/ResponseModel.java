package com.blog2.backend.Common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: goodtimp
 * @Date: 2019/10/10 14:44
 * @description :  响应模板
 */
public class ResponseModel {
    private static final int SUCCESS_CODE = 0;
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

    public static ResponseModel sucess() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(SUCCESS_CODE);
        responseModel.setMsg(SUCCESS_MSG);
        return responseModel;
    }

    public static ResponseModel fail() {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(FAIL_CODE);
        responseModel.setMsg(FAIL_MSG);
        return responseModel;
    }

    public static ResponseModel sucess(Map<String, Object> value) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(SUCCESS_CODE);
        responseModel.setMsg(SUCCESS_MSG);
        responseModel.setExtend(value);
        return responseModel;
    }

    public static ResponseModel fail(Map<String, Object> value) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(FAIL_CODE);
        responseModel.setMsg(FAIL_MSG);
        responseModel.setExtend(value);
        return responseModel;
    }
}
