package com.ares.recycle.request;

import com.ares.recycle.enums.GarbageTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author wangqiaomu
 * @date 2019-07-08 16:44
 **/
@ApiModel(value = "可回收请求参数")
@Data
public class RecycleItemRequest implements Serializable {

    /**
     * 垃圾类型 {@link GarbageTypeEnum}
     */
    @ApiModelProperty(name = "垃圾类型", reference = "GarbageTypeEnum")
    private Integer type;

    /**
     * 垃圾名称
     */
    @ApiModelProperty(name = "垃圾名称")
    private String name;

    public void check() {
        if (type == null && StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("参数不能都为空!");
        }

        if (type != null && GarbageTypeEnum.getEnumByType(type) == null) {
            throw new IllegalArgumentException("垃圾类型非法!");
        }

    }
}
