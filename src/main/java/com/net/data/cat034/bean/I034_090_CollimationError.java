package com.net.data.cat034.bean;

import lombok.Data;

/**
 * 由雷达站计算出的主目标位置相对于SSR目标位置的范围和方位角上的平均差。
 */
@Data
public class I034_090_CollimationError {
    private double RANGE_ERROR;

    private double AZIMUTH_ERROR;

    public final int length = 2;

    private static double lsb1 = 128.0;
    private static double lsb2 = 0.022;

    public I034_090_CollimationError(int[] data, int index) {
        RANGE_ERROR = data[index] / lsb1;
        AZIMUTH_ERROR = data[index + 1] * lsb2;
    }

    @Override
    public String toString() {
        return RANGE_ERROR + "," + AZIMUTH_ERROR;
    }
}
