package com.ares.recycle.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangqiaomu
 * @date 2019-07-09 16:17
 **/
public class BeanCopyUtils {

    private static transient Logger ERROR = LoggerFactory.getLogger(BeanCopyUtils.class);

    public static <S, T> T copy(S from, Class<T> toClazz) {
        if (from == null) {
            return null;
        }

        try {
            T infoTo = toClazz.newInstance();
            BeanUtils.copyProperties(from, infoTo);
            return infoTo;
        } catch (InstantiationException | IllegalAccessException e) {
            ERROR.error(e.getMessage(), e);
        }

        return null;
    }

    public static <S, T> List<T> copy(List<S> from, Class<T> toClazz) {
        if (CollectionUtils.isEmpty(from)) {
            return Collections.emptyList();
        }

        List<T> result = new ArrayList<>(from.size());
        for (S src : from) {
            try {
                T infoTo = toClazz.newInstance();
                BeanUtils.copyProperties(src, infoTo);
                result.add(infoTo);
            } catch (InstantiationException | IllegalAccessException e) {
                ERROR.error(e.getMessage(), e);
            }
        }

        return result;
    }
}
