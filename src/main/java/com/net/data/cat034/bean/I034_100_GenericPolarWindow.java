package com.net.data.cat034.bean;

import lombok.Data;

/**
 * 用极坐标定义的地理窗口。
 */
@Data
public class I034_100_GenericPolarWindow {
    private double RHO_START;
    private double RHO_END;
    private double THETA_START;
    private double THETA_END;

    private static double lsb1 = 256.0;
    private static double lsb2 = 0.0055;
    public final int length = 8;

    public I034_100_GenericPolarWindow(int[] data, int index) {
        RHO_START = (data[index] << 8 | data[index + 1]) / lsb1;
        RHO_END = (data[index + 2] << 8 | data[index + 3]) / lsb1;
        THETA_START = (data[index + 4] << 8 | data[index + 5]) * lsb2;
        THETA_END = (data[index + 6] << 8 | data[index + 7]) * lsb2;
    }

    @Override
    public String toString() {
        return RHO_START + "," + RHO_END + "," + THETA_START + "," + THETA_END;
    }
}
