package com.net.data.cat034.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.net.data.cat034.I034_050.CommonPart;
import com.net.data.cat034.I034_050.SpecificStatusForPSRSensor;
import com.net.data.cat034.I034_050.SpecificStatusForSSRSensor;
import com.net.data.cat034.I034_050.SpecificStatusforModeSSensor;
import lombok.Data;

/**
 * 有关系统的配置和状态的信息。
 */
@Data
public class I034_050_SystemConfigurationAndStatus {
    @JSONField(serialize = false)
    private boolean[] existedItems = new boolean[8];

    private CommonPart commonPart = null;
    private SpecificStatusforModeSSensor specificStatusforModeSSensor = null;
    private SpecificStatusForPSRSensor specificStatusForPSRSensor = null;
    private SpecificStatusForSSRSensor specificStatusForSSRSensor = null;

    public   static int length;

    public I034_050_SystemConfigurationAndStatus(int[] data, int index) {

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


        // 7 4 2
        if (existedItems[7]) {

            commonPart = new CommonPart(data, currentIndex);
            currentIndex += commonPart.length;
        }
        if (existedItems[4]) {

            specificStatusForPSRSensor = new SpecificStatusForPSRSensor(data, currentIndex);
            currentIndex += specificStatusForPSRSensor.length;
        }
        if (existedItems[3]) {

            specificStatusForSSRSensor = new SpecificStatusForSSRSensor(data, currentIndex);
            currentIndex += specificStatusForSSRSensor.length;
        }
        if (existedItems[2]) {

            specificStatusforModeSSensor = new SpecificStatusforModeSSensor(data, currentIndex);
            currentIndex += specificStatusforModeSSensor.length;
        }
        length = currentIndex - index;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(1024);

        return stringBuilder.append(commonPart)
                .append(",").append(specificStatusForSSRSensor)
                .append(",").append(specificStatusForSSRSensor)
                .append(",").append(specificStatusforModeSSensor)
                .toString();
    }
}
