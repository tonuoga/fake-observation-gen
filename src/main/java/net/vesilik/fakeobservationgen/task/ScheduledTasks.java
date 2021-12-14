package net.vesilik.fakeobservationgen.task;

import lombok.extern.java.Log;
import net.vesilik.fakeobservationgen.domain.Message;
import net.vesilik.fakeobservationgen.service.MessageBuilderService;
import net.vesilik.fakeobservationgen.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log
@Component
public class ScheduledTasks {

    @Autowired
    MessageBuilderService messageBuilderService;
    @Autowired
    MessageSenderService messageSenderService;

    @Scheduled(fixedDelayString = "${msg-gen.scheduler.interval-in-ms}")
    public void sendMessage() {
        Message msg = messageBuilderService.getRandomObsMessage();
        messageSenderService.sendMessage(msg);
    }
}
