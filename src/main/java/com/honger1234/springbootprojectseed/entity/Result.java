package com.honger1234.springbootprojectseed.entity;

import lombok.Data;

/**
 * 统一API响应结果封装
 */
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;
}
