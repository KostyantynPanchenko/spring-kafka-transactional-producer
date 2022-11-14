package com.example.transactional.producer.controller;

import com.example.transactional.producer.domain.Student;
import com.example.transactional.producer.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

  private final KafkaProducerService producerService;

  @GetMapping(path = "/kafka-producer/send")
  public void send() {
    producerService.send(new Student("Michael", "Jordan", "basketball"));
  }

  @GetMapping(path = "/kafka-producer/stop")
  public void stop() {
    producerService.send(new Student("Charles", "Barkley", "basketball"));
  }
}
