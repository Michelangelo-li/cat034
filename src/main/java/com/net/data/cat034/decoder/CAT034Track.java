package com.net.data.cat034.decoder;

import com.alibaba.fastjson.annotation.JSONField;
import com.net.data.cat034.bean.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CAT034Track {

    I034_0_MessageType i034_0_messageType;
    I034_010_DataSourceIdentifier i034_010_dataSourceIdentifier;
    I034_020_SectorNumber i034_020_sectorNumber;
    I034_030_TimeOfDay i034_030_timeOfDay;
    I034_041_AntennaRotationSpeed i034_041_antennaRotationSpeed;
    I034_050_SystemConfigurationAndStatus i034_050_systemConfigurationAndStatus;
    I034_060_SystemProcessingMode i034_060_systemProcessingMode;
    I034_070_MessageCountValues i034_070_messageCountValues;
    I034_090_CollimationError i034_090_collimationError;
    I034_100_GenericPolarWindow i034_100_genericPolarWindow;
    I034_110_DataFilter i034_110_dataFilter;
    I034_120_3DPositionOfDataSource i034_120_3DPositionOfDataSource;

    // 指定字段不序列化
    @JSONField(serialize = false)
    private List<Integer> existedItems = new ArrayList<>();

    @JSONField(serialize = false)
    public static int length;

    //index=3,currentIndex += CAT062Track.length,currentIndex += CAT062Track.length;
    //34 0 16 246 22 101 2 42 52 32 224 136 64 64 128 0
    // index = 3
    public CAT034Track(int[] data, int index) {

        // currentIndex = 3
        int currentIndex = index;
        int oByte = 0;
        int itemIndex = 0;

        //data[currentIndex] = f6 = 1111 0110
        do {
            // obyte = 246 1111 0110
            oByte = data[currentIndex];
            //>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；00000001=0x01
            for (int i = 7; i >= 1; i--) {
                //其中对应的位为1
                // oByte >> 7 = 1
                if (((oByte >> i) & 0x01) == 0x01) {
                    //existedItems add 10
                    existedItems.add(CAT034UAP.UAP[itemIndex]);
                }
                itemIndex += 1;
            }
            // currentIndex = 4
            currentIndex += 1;
        } while ((oByte & 0x01) == 0x01);
        //oByte的最后一位为1 说明obyte还是fspec
        ////00000001=0x01 只要oByte的最后一位为1就==，就继续


        for (int item : existedItems) {
            switch (item) {
                case 0:
                    // currentIndex = 4
                    i034_0_messageType = new I034_0_MessageType(data, currentIndex);
                    currentIndex += i034_0_messageType.length;
                    break;
                case 10:
                    i034_010_dataSourceIdentifier = new I034_010_DataSourceIdentifier(data, currentIndex);
                    currentIndex += i034_010_dataSourceIdentifier.length;
                    break;
                case 20:
                    i034_020_sectorNumber = new I034_020_SectorNumber(data, currentIndex);
                    currentIndex += i034_020_sectorNumber.length;
                    break;
                case 30:
                    i034_030_timeOfDay = new I034_030_TimeOfDay(data, currentIndex);
                    currentIndex += i034_030_timeOfDay.length;
                    break;
                case 41:
                    i034_041_antennaRotationSpeed = new I034_041_AntennaRotationSpeed(data, currentIndex);
                    currentIndex += i034_041_antennaRotationSpeed.length;
                    break;
                case 50:
                    i034_050_systemConfigurationAndStatus = new I034_050_SystemConfigurationAndStatus(data, currentIndex);
                    currentIndex += i034_050_systemConfigurationAndStatus.length;
                    break;
                case 60:
                    i034_060_systemProcessingMode = new I034_060_SystemProcessingMode(data, currentIndex);
                    currentIndex += i034_060_systemProcessingMode.length;
                    break;
                case 70:
                    i034_070_messageCountValues = new I034_070_MessageCountValues(data, currentIndex);
                    currentIndex += i034_070_messageCountValues.length;
                    break;
                case 90:
                    i034_090_collimationError = new I034_090_CollimationError(data, currentIndex);
                    currentIndex += i034_090_collimationError.length;
                    break;
                case 100:
                    i034_100_genericPolarWindow = new I034_100_GenericPolarWindow(data, currentIndex);
                    currentIndex += i034_100_genericPolarWindow.length;
                    break;
                case 110:
                    i034_110_dataFilter = new I034_110_DataFilter(data, currentIndex);
                    currentIndex += i034_110_dataFilter.length;
                    break;
                case 120:
                    i034_120_3DPositionOfDataSource = new I034_120_3DPositionOfDataSource(data, currentIndex);
                    currentIndex += i034_120_3DPositionOfDataSource.length;
                    break;
                case -1:
                    currentIndex += data[currentIndex];
                    break;
                case -2:
                    while ((data[currentIndex] & 0x01) == 0x01) {
                        currentIndex += 1;
                    }
                    currentIndex += 1;
                    break;
                default:
                    // 10 20
                    if (item <= -3 && item >= -100) {
                        currentIndex += (data[currentIndex] * (-2 - item) + 1);
                    } else if (item < -100) {
                        currentIndex += (-100 - item);
                    }
                    break;
            }
        }
        length = currentIndex - index;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(2048);

        return stringBuilder.append(i034_0_messageType)
                .append(",").append(i034_010_dataSourceIdentifier)
                .append(",").append(i034_020_sectorNumber)
                .append(",").append(i034_030_timeOfDay)
                .append(",").append(i034_041_antennaRotationSpeed)
                .append(",").append(i034_050_systemConfigurationAndStatus)
                .append(",").append(i034_060_systemProcessingMode)
                .append(",").append(i034_070_messageCountValues)
                .append(",").append(i034_090_collimationError)
                .append(",").append(i034_100_genericPolarWindow)
                .append(",").append(i034_110_dataFilter)
                .append(",").append(i034_120_3DPositionOfDataSource)
                .toString();
    }

}
