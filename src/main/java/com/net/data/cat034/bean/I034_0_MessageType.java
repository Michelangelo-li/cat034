package com.net.data.cat034.bean;

import lombok.Data;

/**
 *此数据项通过进一步定义事务类型，可以更方便地处理接收器端的消息。
 * • 001 North Marker message
 * • 002 Sector crossing message
 * • 003 Geographical filtering message
 * • 004 Jamming Strobe message
 */
@Data
public class I034_0_MessageType {

    private int messageType;

    public static final int length = 1;

    public I034_0_MessageType(int[] data, int index) {
        messageType = data[index];
    }

    @Override
    public String toString() {
        return messageType + "";
    }
}
