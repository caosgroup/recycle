package com.ares.recycle.common.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 单位
 *
 * @author wangqiaomu
 * @date 2019-07-12 14:33
 **/
public interface Unit<U extends Unit> extends Describe {

    U baseUnit();

    String desc();

    String symbol();

    double proportion();

    default double convert(double source, U targetUnit) {
        return convert(source, targetUnit, 2, RoundingMode.DOWN);
    }

    default double convert(double source, U targetUnit, int scale, RoundingMode roundingMode) {
        return BigDecimal.valueOf(source)
                .multiply(BigDecimal.valueOf(targetUnit.proportion()))
                .divide(BigDecimal.valueOf(proportion()), scale, roundingMode)
                .doubleValue();
    }
}
