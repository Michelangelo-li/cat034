package com.net.data.cat034.bean;

import lombok.Data;

/**
 * 绝对时间戳表示为UTC时间
 * (LSB) = (2-7)s = 1/128 s
 * the time is reset to zero at every midnight
 */
@Data
public class I034_030_TimeOfDay {

    public static final int length = 3;

    private double timeOfDay;

    private static double lsb = 128.0;

    public I034_030_TimeOfDay(int[] data, int index) {
        timeOfDay = (data[index] << 16 | data[index + 1] << 8 | data[index + 2]) / lsb;
    }

    @Override
    public String toString() {
        return timeOfDay + "";
    }
}
