package com.net.data.cat034.decoder;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CAT034KafkaMsg {

    private String data;

    private int dataLength;

    private String dataType;

    private String encode;

    private String dataHashCode;

    private long receiveTime;

    private long sendTime;

    private long seqNo;

    private String serviceId;

    private String serviceIp;

    private String serviceVersion;

    private String sourceIp;

    private int sourcePort;

}
