package com.net.data.cat034.bean;


import lombok.Data;

/**
 * 连续两个北交叉或一段时间内的天线旋转周期。
 * (LSB) = (2-7) s = 1/128 s
 */
@Data
public class I034_041_AntennaRotationSpeed {
    public static final int length = 2;
    private double antennaRotationSpeed;
    private static double lsb = 128.0;

    public I034_041_AntennaRotationSpeed(int[] data, int index) {
        antennaRotationSpeed = (data[index] << 8 | data[index + 1]) / lsb;
    }

    @Override
    public String toString() {
        return antennaRotationSpeed + "";
    }
}
