package com.net.data.cat034.bean;

import lombok.Data;

/**
 * 对于上次完成的天线旋转，根据各种类型的消息计数值在两个北交叉之间计数
 */
@Data
public class I034_070_MessageCountValues {
    private int REP;
    private int TYP;
    private int COUNTER;
    public final int length = 3;

    public I034_070_MessageCountValues(int[] data, int index) {
        REP = data[index];
        TYP = (data[index + 1] >> 3) & 0x1f;
        COUNTER = (data[index + 1] << 5) | data[index + 2];
    }

    @Override
    public String toString() {
        return REP + "," + TYP + "," + COUNTER;
    }
}
