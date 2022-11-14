package com.example.transactional.producer.service;

import com.example.transactional.producer.domain.Student;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {

  public static final String TOPIC = "students";
  public static final String HISTORY_TOPIC = "students-history";
  private final KafkaTemplate<String, Student> kafkaProducer;

  @Transactional
  @SneakyThrows
  public void send(final Student student) {
    kafkaProducer.send(TOPIC, student.getLastName(), student)
        .addCallback(onSuccess(student, TOPIC), onFailure(student, TOPIC));

    // see how consumer processes the message only after this transaction ends
    Thread.sleep(1500);

    kafkaProducer.send(HISTORY_TOPIC, student.getLastName(), student)
        .addCallback(onSuccess(student, HISTORY_TOPIC), onFailure(student, HISTORY_TOPIC));
  }

  private static SuccessCallback<? super SendResult<String, Student>> onSuccess(
      final Student student, final String topic) {
    return (SendResult<String, Student> sendResult) -> log.info("Successfully sent {} {} to {}",
        student.getFirstName(), student.getLastName(), topic);
  }

  private static FailureCallback onFailure(final Student student, final String topic) {
    return (Throwable ex) -> log.error("Could not sent {} {} to {}", student.getFirstName(),
        student.getLastName(), topic, ex);
  }
}
