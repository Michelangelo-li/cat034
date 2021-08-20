package com.net.data.cat034.bean;

import lombok.Data;

/**
 * 数据过滤器，它允许抑制单个数据类型。
 */
@Data
public class I034_110_DataFilter {
    private int TYP;
    public final int length = 1;

    public I034_110_DataFilter(int[] data, int index) {
        TYP = data[index];
    }

    @Override
    public String toString() {
        return TYP + "";
    }
}
