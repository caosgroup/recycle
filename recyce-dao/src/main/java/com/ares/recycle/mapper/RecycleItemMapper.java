package com.ares.recycle.mapper;

import com.ares.recycle.po.RecycleItemPO;

public interface RecycleItemMapper {
    int insert(RecycleItemPO record);

    int insertSelective(RecycleItemPO record);
}