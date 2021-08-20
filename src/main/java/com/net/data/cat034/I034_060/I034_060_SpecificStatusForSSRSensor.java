package com.net.data.cat034.I034_060;

import lombok.Data;

/**
 * 模式S传感器的特定处理模式信息
 */
@Data
public class I034_060_SpecificStatusForSSRSensor {
    public static final int length = 1;
    private String RED_RAD;

    public I034_060_SpecificStatusForSSRSensor(int[] data, int index) {
        RED_RAD = ((data[index] >> 7) & 0x01) + "" + ((data[index] >> 6) & 0x01) + ((data[index] >> 5) & 0x01);
    }

    @Override
    public String toString() {
        return RED_RAD + "";
    }
}
