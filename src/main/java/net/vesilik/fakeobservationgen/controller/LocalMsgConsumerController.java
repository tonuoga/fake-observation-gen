package net.vesilik.fakeobservationgen.controller;

import lombok.extern.java.Log;
import net.vesilik.fakeobservationgen.domain.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;

@RestController
@RequestMapping(path = "/localconsumer")
@Log
public class LocalMsgConsumerController {

    @PostMapping(path= "/", consumes = "application/json", produces = "text/plain")
    public ResponseEntity<String> consumeMessage(@RequestBody Message message) {
        log.info(message.toString());
        return new ResponseEntity<>("processed", HttpStatus.OK);
    }
}
