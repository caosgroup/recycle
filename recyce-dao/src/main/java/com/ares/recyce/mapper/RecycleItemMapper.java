package com.ares.recyce.mapper;

import com.ares.recyce.po.RecycleItemPO;

public interface RecycleItemMapper {
    int insert(RecycleItemPO record);

    int insertSelective(RecycleItemPO record);
}