package com.deusto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="books")
public class Book {
  @Id
  private Long id;
  
}//potom
