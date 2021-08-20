package com.net.data.cat034.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.net.data.cat034.I034_060.I034_060_CommonPart;
import com.net.data.cat034.I034_060.I034_060_SpecificStatusForPSRSensor;
import com.net.data.cat034.I034_060.I034_060_SpecificStatusForSSRSensor;
import com.net.data.cat034.I034_060.I034_060_SpecificStatusforModeSSensor;
import lombok.Data;

/**
 * 上次天线旋转期间使用的组成系统的各种传感器的处理选项的状态。
 */
@Data
public class I034_060_SystemProcessingMode {
    @JSONField(serialize = false)
    private final boolean[] existedItems = new boolean[8];

    private I034_060_CommonPart i034_060_commonPart = null;
    private I034_060_SpecificStatusforModeSSensor i034_060_specificStatusforModeSSensor = null;
    private I034_060_SpecificStatusForPSRSensor i034_060_specificStatusForPSRSensor = null;
    private I034_060_SpecificStatusForSSRSensor i034_060_specificStatusForSSRSensor = null;

    public static int length;

    public I034_060_SystemProcessingMode(int[] data, int index) {

        int currentIndex = index;

        int oByte = 0;

        int itemIndex = 8;

        do {
            // adr
            oByte = data[currentIndex];

            for (int i = 7; i >= 1; i--) { //7
                itemIndex -= 1; //31
                // 1 为 true
                existedItems[itemIndex] = ((oByte >> i) & 0x01) == 0x01;
            }
            itemIndex -= 1;
            currentIndex += 1;

        } while ((oByte & 0x01) == 0x01);

//        for (int i = 0; i < existedItems.length; i++) {
//            System.out.println("060:existedItems" + existedItems[i]);
//        }

        if (existedItems[7]) {
            i034_060_commonPart = new I034_060_CommonPart(data, currentIndex);
            currentIndex += I034_060_CommonPart.length;
        }
        if (existedItems[4]) {
            i034_060_specificStatusForPSRSensor = new I034_060_SpecificStatusForPSRSensor(data, currentIndex);
            currentIndex += I034_060_SpecificStatusForPSRSensor.length;
        }
        if (existedItems[3]) {
            i034_060_specificStatusForSSRSensor = new I034_060_SpecificStatusForSSRSensor(data, currentIndex);
            currentIndex += I034_060_SpecificStatusForSSRSensor.length;
        }
        if (existedItems[2]) {
            i034_060_specificStatusforModeSSensor = new I034_060_SpecificStatusforModeSSensor(data, currentIndex);
            currentIndex += I034_060_SpecificStatusforModeSSensor.length;
        }
        length = currentIndex - index;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(1024);
        return stringBuilder.append(i034_060_commonPart)
                .append(",").append(i034_060_specificStatusForPSRSensor)
                .append(",").append(i034_060_specificStatusForSSRSensor)
                .append(",").append(i034_060_specificStatusforModeSSensor)
                .toString();
    }
}
