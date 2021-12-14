package net.vesilik.fakeobservationgen.service;

import lombok.extern.java.Log;
import net.vesilik.fakeobservationgen.domain.Message;
import net.vesilik.fakeobservationgen.domain.MsgLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Service
@Log
public class MessageBuilderService {

    @Value("${msg-gen.random.area-lat-min}")
    private Float areaLatMin;
    @Value("${msg-gen.random.area-lat-max}")
    private Float areaLatMax;
    @Value("${msg-gen.random.area-lon-min}")
    private Float areaLonMin;
    @Value("${msg-gen.random.area-lon-max}")
    private Float areaLonMax;
    @Value("${msg-gen.sender.code}")
    private String senderCode;

    public Message getRandomObsMessage() {
        Message msg = new Message();
        msg.setId(UUID.randomUUID().toString());
        msg.setTimestamp(new Date());
        msg.setLevel(MsgLevel.values()[new Random().nextInt(MsgLevel.values().length)]);
        msg.setSenderCode(senderCode);
        msg.setCoordLat(getRndFloat(areaLatMin, areaLatMax));
        msg.setCoordLon(getRndFloat(areaLonMin, areaLonMax));
        msg.setMessage(String.format("Some %s level message", msg.getLevel().name()));
        return msg;
    }

    private Float getRndFloat(Float min, Float max) {
        if (min == null | max == null) return null;
        return min + new Random().nextFloat() * (max - min);
    }
}
