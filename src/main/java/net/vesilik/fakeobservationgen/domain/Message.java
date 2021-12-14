package net.vesilik.fakeobservationgen.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Message {

    private String id;

    private Date timestamp;

    private MsgLevel level;

    private String senderCode;

    private Float coordLat;

    private Float coordLon;

    private String message;
}
