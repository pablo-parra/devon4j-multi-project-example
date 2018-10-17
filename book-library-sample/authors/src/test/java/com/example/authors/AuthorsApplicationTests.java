package com.example.authors;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.authors.management.logic.api.Authormanagement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorsApplicationTests {

  @Autowired
  private Authormanagement authormanagement;

  @Test
  public void getAuthors() {

    assertThat(this.authormanagement.getAuthors().size()).isEqualTo(2);
  }

}
