package com.honger1234.springbootprojectseed.util;


import com.honger1234.springbootprojectseed.entity.CodeEnum;
import com.honger1234.springbootprojectseed.entity.Result;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {

    /**
     * 成功相应，不带返回参数
     * @return
     */
    public static Result genSuccessResult() {
        Result result = new Result();
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setMsg(CodeEnum.SUCCESS.getMsg());
        return result;
    }

    /**
     * 成功相应，带返回参数
     * @param data 返回数据
     * @param <T> 数据类型
     * @return
     */
    public static <T> Result<T> genSuccessResult(T data) {
        Result result = new Result();
        result.setCode(CodeEnum.SUCCESS.getCode());
        result.setMsg(CodeEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 操作失败，默认提示信息
     * @return
     */
    public static Result genFailResult() {
        Result result = new Result();
        result.setCode(CodeEnum.FAIL.getCode());
        result.setMsg(CodeEnum.FAIL.getMsg());
        return result;
    }

    /**
     * 操作失败，自定义失败提示信息
     * @param message
     * @return
     */
    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setCode(CodeEnum.FAIL.getCode());
        result.setMsg(message);
        return result;
    }

    /**
     * 内部服务器错误
     * @return
     */
    public static Result genErrorResult(){
        Result result = new Result();
        result.setCode(CodeEnum.INTERNAL_SERVER_ERROR.getCode());
        result.setMsg(CodeEnum.INTERNAL_SERVER_ERROR.getMsg());
        return result;
    }
}
