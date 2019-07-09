package com.ares.recycle.mapper;

import com.ares.recycle.po.RecycleItemPO;
import com.ares.recycle.request.RecycleItemRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecycleItemMapper {

    int insert(RecycleItemPO record);

    int insertSelective(RecycleItemPO record);

    List<RecycleItemPO> list(@Param("request") RecycleItemRequest request);
}