package com.net.data.cat034.I034_060;


import lombok.Data;

@Data
public class I034_060_SpecificStatusForPSRSensor {
    public static final int length = 1;
    private int POL;
    private String RED_RAD;
    private String STC;


    public I034_060_SpecificStatusForPSRSensor(int[] data, int index) {
        POL = data[index] >> 7;
        RED_RAD = ((data[index] >> 6) & 0x01) + "" + ((data[index] >> 5) & 0x01) + ((data[index] >> 4) & 0x01);
        //0011
        STC = ((data[index] >> 3) & 0x01) + "" + ((data[index] >> 2) & 0x01);
    }

    @Override
    public String toString() {
        return POL + "," + RED_RAD + "," + STC;
    }
}
