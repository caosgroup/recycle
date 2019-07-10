package com.ares.recycle.service.impl;

import com.ares.recycle.common.util.BeanCopyUtils;
import com.ares.recycle.bo.RecycleItemBO;
import com.ares.recycle.mapper.RecycleItemMapper;
import com.ares.recycle.po.RecycleItemPO;
import com.ares.recycle.request.RecycleItemRequest;
import com.ares.recycle.service.RecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author wangqiaomu
 * @date 2019-07-09 11:02
 **/
@Service
public class RecycleServiceImpl implements RecycleService {

    @Autowired
    private RecycleItemMapper recycleItemMapper;

    @Override
    public List<RecycleItemBO> list(RecycleItemRequest request) {
        if (!StringUtils.isEmpty(request.getName())) {
            request.setName("%" + request.getName() + "%");
        }
        List<RecycleItemPO> poList = recycleItemMapper.list(request);
        return BeanCopyUtils.copy(poList, RecycleItemBO.class);
    }
}
