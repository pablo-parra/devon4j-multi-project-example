package com.example.books;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.books.management.logic.api.Bookmanagement;
import com.example.books.management.logic.api.dto.BookDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksApplicationTests {

  @Autowired
  private Bookmanagement bookmanagement;

  @Test
  public void getBooksTest() {

    List<BookDTO> books = this.bookmanagement.getAllBooks();
    assertThat(books.size()).isEqualTo(3);
  }

}
