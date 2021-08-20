package com.net.data.cat034.I034_050;

import lombok.Data;

/**
 * 第一个辅助子字段(COM)包含系统的公共元素的状态。
 * Bit-6 (RDPR) is sent only once after the event.
 */
@Data
public class CommonPart {
    public static final int length = 1;

    private int nogo;
    private int rdpc;
    private int rdpr;
    private int ovlRdp;
    private int ovlXmt;
    private int msc;
    private int tsv;


    public CommonPart(int[] data, int index) {
        nogo = data[index] >> 7;
        rdpc = (data[index] >> 6) & 0x01;
        rdpr = (data[index] >> 5) & 0x01;
        ovlRdp = (data[index] >> 4) & 0x01;
        ovlXmt = (data[index] >> 3) & 0x01;
        msc = (data[index] >> 2) & 0x01;
        tsv = (data[index] >> 1) & 0x01;
    }

    @Override
    public String toString() {
        return nogo + "," + rdpc + "," + rdpr + "," + ovlRdp + "," + ovlXmt + "," + msc + "," + tsv;
    }
}
