package com.example.tutorial.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client", produces = "application/json")
@Slf4j
public class ClientEndpoint {

  @RequestMapping(value = "/readFromQueue/{queueName}", method = RequestMethod.GET)
  public ResponseEntity triggerReadingFromQueue() {
    log.debug("triggerReadingFromQueue...");
    String queueName = "Action.Notify";
    return ResponseEntity.noContent().build();
  }

}
