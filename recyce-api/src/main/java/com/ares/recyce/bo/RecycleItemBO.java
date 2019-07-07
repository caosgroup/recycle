package com.ares.recyce.bo;

import lombok.Data;

import java.util.Date;

@Data
public class RecycleItemBO {
    private Long id;

    private String name;

    private Integer type;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;
}