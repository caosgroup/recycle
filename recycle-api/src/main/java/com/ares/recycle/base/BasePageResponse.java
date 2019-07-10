package com.ares.recycle.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author wangqiaomu
 * @date 2019-07-08 19:32
 **/
@Data
public class BasePageResponse<T> implements Serializable {

    private Boolean success;

    private Integer code;

    private String errorMsg;

    private Collection<T> data;
}
