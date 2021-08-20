package com.net.data.cat034.I034_050;

import lombok.Data;

/**
 * Mode S传感器的特定状态信息
 */
@Data
public class SpecificStatusforModeSSensor {
    public static final int length = 2;

    private int ant;
    private String ch_ab;
    private int ovlSur;
    private int msc;
    private int scf;
    private int dlf;
    private int ovlScf;
    private int ovlDlf;

    public SpecificStatusforModeSSensor(int[] data, int index) {
        ant = (data[index] >> 15) & 0x01;
        // 0011 3
        ch_ab = ((data[index] >> 6) & 0x01) + "" + ((data[index] >> 5) & 0x01);
        ovlSur = (data[index]>>12) & 0x01;
        msc = (data[index]>>11) & 0x01;
        scf = (data[index]>>10) & 0x01;
        dlf = (data[index]>>9) & 0x01;
        ovlScf = (data[index]>>8) & 0x01;
        ovlDlf =(data[index]>>7) & 0x01;
    }

    @Override
    public String toString() {
        return ant + "," + ch_ab + "," + ovlSur + "," + msc + "," + msc + "," + dlf + "," + ovlScf + "," + ovlDlf;
    }
}
