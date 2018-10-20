package io.devonfw.application.books.bookmanagement;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.devonfw.application.books.bookmanagement.logic.api.Bookmanagement;
import io.devonfw.application.books.bookmanagement.logic.api.to.BookEto;
import io.devonfw.application.books.bookmanagement.logic.api.to.BookSearchCriteriaTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BooksApplicationTests {

  @Autowired
  private Bookmanagement bookmanagement;

  @Test
  public void getBooksTest() {

    List<BookEto> books = this.bookmanagement.findBookEtos(new BookSearchCriteriaTo());
    assertEquals(3, books.size());
  }

}
