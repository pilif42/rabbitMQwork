package com.example.tutorial.service.impl;

import com.example.tutorial.service.OutputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.gov.ons.ctp.response.action.message.instruction.ActionRequest;

@Slf4j
@Service
public class OutputServiceImpl implements OutputService {
  public void process(ActionRequest actionRequest) {
    log.debug("Entering process with actionRequest {}", actionRequest);
  }
}
