package com.example.tutorial.service;

import uk.gov.ons.ctp.response.action.message.instruction.ActionRequest;

public interface OutputService {
  void process(ActionRequest actionRequest);
}
