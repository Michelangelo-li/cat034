package com.net.data.cat034.I034_060;

import lombok.Data;

@Data
public class I034_060_SpecificStatusforModeSSensor {
    public static final int length = 2;
    private String RED_RAD;
    private int CLU;


    public I034_060_SpecificStatusforModeSSensor(int[] data, int index) {
        RED_RAD = ((data[index] >> 7) & 0x01) + "" + ((data[index] >> 6) & 0x01) + ((data[index] >> 5) & 0x01);
        CLU = (data[index] >> 4) & 0x01;
    }

    @Override
    public String toString() {
        return RED_RAD + "," + CLU;
    }
}
