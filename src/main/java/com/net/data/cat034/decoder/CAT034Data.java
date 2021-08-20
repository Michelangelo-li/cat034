package com.net.data.cat034.decoder;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CAT034Data {

    public static final int CAT034_ID = 34;

//    @Getter
//    @Setter
//    private long receiveTime;

    @Getter
    @Setter
    private CAT034Track[] trackArray;

    @Getter
    @Setter
    @JSONField(serialize = false)
    private List<CAT034Track> trackList;


    public CAT034Data(int[] data, int startIndex, int dataLength) throws Exception {
        int currentIndex = startIndex;

        if (data[currentIndex] != CAT034_ID) {
            throw new Exception("不是ASTERIX-CAT034格式数据");
        }

        // UAP中的lenth 为int数组的第二位和第三位的和
        int length = (data[currentIndex + 1] << 8) + data[currentIndex + 2];
//        System.out.println("lenth:"+length);
//        if (dataLength != length || data.length - startIndex < dataLength) {
//            throw new Exception("ASTERIX-CAT062数据长度错误");
//        }

        currentIndex += 3;
        trackList = new ArrayList();

        //startIndex=0
        //3
        //
        while (currentIndex - startIndex < length) {

            // int[] data currentIndex = 3
            CAT034Track track = new CAT034Track(data, currentIndex);

            trackList.add(track);
            currentIndex += CAT034Track.length;
        }


        if (currentIndex - startIndex != length) {

            throw new Exception("ASTERIX CAT034数据解析错误。");
        }
        this.trackArray = trackList.toArray(new CAT034Track[]{});

//        this.receiveTime = receiveTime;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(4096);
//        stringBuilder.append(receiveTime);

        for (CAT034Track track : trackList) {
//            stringBuilder.append("#").append(track.toString());
            stringBuilder.append(track.toString());
        }
        return stringBuilder.toString();
    }

}
