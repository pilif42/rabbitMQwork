package com.example.tutorial.service.impl;

import com.example.tutorial.service.OutputService;
import com.example.tutorial.utility.CSVUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.gov.ons.ctp.response.action.message.instruction.ActionContact;
import uk.gov.ons.ctp.response.action.message.instruction.ActionRequest;

import java.io.FileWriter;
import java.util.Arrays;

@Slf4j
@Service
public class OutputServiceImpl implements OutputService {

  public void process(ActionRequest actionRequest) {
    log.debug("Entering process with actionRequest {}", actionRequest);

    ActionContact contact = actionRequest.getContact();
    if (contact != null) {
      String csvFile = "/Users/philippebrossier/code_perso/rabbitMQwork/queueDump.csv";
      try {
        FileWriter writer = new FileWriter(csvFile, true);
        CSVUtils.writeLine(writer, Arrays.asList(contact.getForename(),
            contact.getSurname(),
            contact.getEmailAddress()));
        writer.flush();
        writer.close();
      } catch (Exception e) {
        log.error("Exception with msg {} and cause {}", e.getMessage(), e.getCause());
      }
    }
  }
}
