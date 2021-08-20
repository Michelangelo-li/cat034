package com.net.data.cat034.bean;


import lombok.Data;

/**
 * 天线方位角的八个最重要的位元定义了一个特定的方位角扇区。
 * (LSB) = 360°/(2^8) = approx. 1.41°
 */
@Data
public class I034_020_SectorNumber {
    public static final int length = 1;
    private double sectorNumer;
    private static double lsb = 1.41;

    public I034_020_SectorNumber(int[] data, int index) {
        sectorNumer = (data[index]) * lsb;
    }

    @Override
    public String toString() {
        return sectorNumer + "";
    }
}
