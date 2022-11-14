package com.example.transactional.producer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {

  private String firstName;
  private String lastName;
  private String discipline;

}
