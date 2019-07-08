package com.ares.recycle.enums;

/**
 * @author wangqiaomu
 * @date 2019-07-08 16:46
 **/
public enum GarbageTypeEnum {

    /**
     * 可回收物类型枚举
     * 垃圾类型 1:干垃圾,2:湿垃圾,3:有害垃圾,4:可回收垃圾
     */
    DRY_GARBAGE(1, "干垃圾"),
    WET_GARBAGE(2, "湿垃圾"),
    HARMFUL_GARBAGE(3, "有害垃圾"),
    RECYCLABLE_GARBAGE(4, "可回收垃圾"),
    OTHER(99, "其他"),
    ;

    private Integer type;

    private String alias;

    GarbageTypeEnum(Integer type, String alias) {
        this.type = type;
        this.alias = alias;
    }

    public Integer getType() {
        return type;
    }

    public String getAlias() {
        return alias;
    }
}
