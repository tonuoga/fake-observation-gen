package net.vesilik.fakeobservationgen.service;

import lombok.extern.java.Log;
import net.vesilik.fakeobservationgen.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log
public class MessageSenderService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${msg-gathering-server.url}")
    private String url;

    public void sendMessage(Message msg) {
        String response = restTemplate.postForObject(url, msg, String.class);
        log.info("Return value: " + response);
    }
}
