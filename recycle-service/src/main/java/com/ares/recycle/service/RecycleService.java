package com.ares.recycle.service;

import com.ares.recycle.bo.RecycleItemBO;
import com.ares.recycle.request.RecycleItemRequest;

import java.util.List;

/**
 * @author wangqiaomu
 * @date 2019-07-09 11:02
 **/
public interface RecycleService {

    List<RecycleItemBO> list(RecycleItemRequest request);
}
