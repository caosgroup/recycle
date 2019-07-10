package com.ares.recycle.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangqiaomu
 * @date 2019-07-08 19:31
 **/
@Data
public class BaseResponse<T> implements Serializable {

    private Boolean success;

    private Integer code;

    private String errorMsg;

    private T data;
}
