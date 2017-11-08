package com.example.tutorial.message.impl;

import com.example.tutorial.message.ActionInstructionReceiver;
import com.example.tutorial.service.OutputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.ons.ctp.response.action.message.instruction.ActionInstruction;

/**
 * The service that reads ActionInstructions from the inbound channel
 */
@Slf4j
@MessageEndpoint
public class ActionInstructionReceiverImpl implements ActionInstructionReceiver {

  @Autowired
  private OutputService outputService;

  /**
   * To process ActionInstructions from the input channel actionInstructionTransformed
   *
   * @param instruction the ActionInstruction to be processed
   */
  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
// TODO  @ServiceActivator(inputChannel = "actionInstructionTransformed", adviceChain = "actionInstructionRetryAdvice")
  @ServiceActivator(inputChannel = "actionInstructionTransformed")
  public void processInstruction(final ActionInstruction instruction) {
    log.debug("entering process with instruction {}", instruction);
    outputService.process(instruction.getActionRequest());
  }
}
