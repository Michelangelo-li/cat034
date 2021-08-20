package com.net.data.cat034.I034_050;


import lombok.Data;

/**
 * PSR传感器的特定状态信息
 */
@Data
public class SpecificStatusForPSRSensor {
    public static final int length = 1;
    private int ant;
    private String ch_ab;
    private int ovl;
    private int msc;

    public SpecificStatusForPSRSensor(int[] data, int index) {
        ant = (data[index] >> 7) & 0x01;
        ch_ab = ((data[index] >> 6) & 0x01) + "" + ((data[index] >> 5) & 0x01);
        ovl = (data[index] >> 4) & 0x01;
        msc = (data[index] >> 3) & 0x01;
    }

    @Override
    public String toString() {
        return ant + "," + ch_ab + "," + ovl + "," + msc;
    }
}
