package com.net.data.cat034.I034_060;

import lombok.Data;

/**
 *
 */
@Data
public class I034_060_CommonPart {
    public static final int length = 1;

    private String RED_RDP;
    private String RED_XMT;

    public I034_060_CommonPart(int[] data, int index) {
        // 0111 4+2+1
        RED_RDP = ((data[index] >> 6) & 0x01) + "" + ((data[index] >> 5) & 0x01) + ((data[index] >> 4) & 0x01);
        RED_XMT = ((data[index] >> 3) & 0x01) + "" + ((data[index] >> 2) & 0x01) + ((data[index] >> 1) & 0x01);
    }

    @Override
    public String toString() {
        return RED_RDP + ", " + RED_XMT;
    }
}
