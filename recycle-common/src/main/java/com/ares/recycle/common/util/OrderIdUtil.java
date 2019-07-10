package com.ares.recycle.common.util;


import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * 随机ID生成Util
 *
 * @author qiaomu.wang
 * @date 2018-10-30
 */
public class OrderIdUtil {

    /**
     * 默认前缀
     */
    private static final String DEFAULT_PEFIX = "OR";
    private static int RADIO = 36;
    private static Random random = new Random();

    /**
     * 生成订单展示ID
     *
     * @param id 订单自增ID，若无可使用时间戳
     * @return 随机OrderViewId
     */
    public static String trans2OrderViewId(long id) {
        return trans2ViewId(DEFAULT_PEFIX, id);
    }

    /**
     * 生成订单展示ID
     *
     * @param prefix 订单展示前缀
     * @param id 订单自增ID，若无可使用时间戳
     * @return 随机OrderViewId
     */
    public static String trans2OrderViewId(String prefix, long id) {
        return trans2ViewId(prefix, id);
    }

    private static String trans2ViewId(String preFix, long orderId) {
        return (preFix + trans2ThirtySixRadio(orderId, 12) + trans2ThirtySixRadio((long)random.nextInt(RADIO * RADIO), 2)).toUpperCase();
    }

    private static String trans2ThirtySixRadio(long originValue, int maxLength) {
        long tmpValue = originValue;

        StringBuilder sb;
        for(sb = new StringBuilder(20); tmpValue != 0L; tmpValue /= (long)RADIO) {
            sb.append(toChar((int)(tmpValue % (long)RADIO)));
        }

        return StringUtils.leftPad(sb.reverse().toString(), maxLength, "0");
    }

    private static long trans2Value(String originValue) {
        long targetValue = 0L;

        int firstNotZero;
        for(firstNotZero = 0; originValue.charAt(firstNotZero) == 48; ++firstNotZero) {
        }
//        int firstNotZero = originValue.indexOf(48);

        String tmpValue = originValue.substring(firstNotZero);

        for(int i = 0; i < tmpValue.length(); ++i) {
            targetValue = targetValue * RADIO + (long)toValue(tmpValue.charAt(i));
        }

        return targetValue;
    }

    /**
     * 根据生成的orderViewId转换出原数据
     *
     * @param orderViewId 订单展示ID
     * @return 原数据
     */
    public static long trans2Id(String orderViewId) {
        String tmpValue = orderViewId.substring(DEFAULT_PEFIX.length(), orderViewId.length() - 2);
        return trans2Value(tmpValue);
    }

    /**
     * 根据生成的orderViewId转换出原数据
     *
     * @param prefix      前缀
     * @param orderViewId orderViewId
     * @return 原数据
     */
    public static long trans2Id(String prefix, String orderViewId) {
        String tmpValue = orderViewId.substring(prefix.length(), orderViewId.length() - 2);
        return trans2Value(tmpValue);
    }

    private static char toChar(int value) {
        if (value >= 0 && value < 10) {
            return (char)(48 + value);
        } else if (value < RADIO) {
            return (char)(value - 10 + 97);
        } else {
            throw new RuntimeException("invalid valud: " + value);
        }
    }

    private static int toValue(char chr) {
        char tmpChr = Character.toLowerCase(chr);
        if (tmpChr >= '0' && tmpChr <= '9') {
            return chr - 48;
        } else if (tmpChr >= 'a' && tmpChr <= 'z') {
            return tmpChr - 97 + 10;
        } else {
            throw new RuntimeException("invalid char: chr" + chr);
        }
    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        String viewId = trans2OrderViewId(now);
        System.out.println(now);
        System.out.println(viewId);
        System.out.println(trans2Id(viewId));
    }

}
