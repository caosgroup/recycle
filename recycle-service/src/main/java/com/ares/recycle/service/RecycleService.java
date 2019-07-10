package com.ares.recycle.service;

import com.ares.recycle.bo.RecycleItemBO;
import com.ares.recycle.request.RecycleItemRequest;

import java.util.List;

/**
 * @author wangqiaomu
 * @date 2019-07-09 11:02
 **/
public interface RecycleService {

    /**
     * 条件查询可回收垃圾信息
     *
     * @param request 请求request
     * @return boList
     */
    List<RecycleItemBO> list(RecycleItemRequest request);
}
