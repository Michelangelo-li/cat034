package com.net.data.cat034.bean;

import lombok.Data;

/**
 * 数据源在WGS84坐标中的三维位置
 */
@Data
public class I034_120_3DPositionOfDataSource {
    private int Height_in_WGS84;
    private double Latitude_in_WGS84;
    private double Longitude_in_WGS84;
    public final int length = 8;
    private static double lsb = 2.145767 * 0.00001;

    public I034_120_3DPositionOfDataSource(int[] data, int index) {
        Height_in_WGS84 = data[index] << 8 | data[index + 1];
        Latitude_in_WGS84 = (data[index + 2] << 16 | data[index + 3] << 8 | data[index + 4]) * lsb;
        Longitude_in_WGS84 = (data[index + 5] << 16 | data[index + 6] << 8 | data[index + 7]) * lsb;
    }

    @Override
    public String toString() {
        return Height_in_WGS84 + "," + Latitude_in_WGS84 + "," + Longitude_in_WGS84;
    }
}
