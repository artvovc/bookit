package com.deusto.unit.test.builders;

import com.deusto.builders.BookBuilder;
import com.deusto.dtos.BookDTO;
import com.deusto.models.Book;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class BookBuilderUTest extends AbstractUT {

    @Test
    public void validBookBuilderUTest() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthorLastName("AuthorLastName");
        bookDTO.setAuthorFirstName("AuthorFirstName");
        bookDTO.setAgeLimit(18);
        bookDTO.setCount(200);

        assertTrue(BookBuilder.get(bookDTO) != null);
        assertTrue(BookBuilder.get(bookDTO) instanceof Book);

        Book book = BookBuilder.get(bookDTO);

        assertThat(book.getCount(), is(200));
        assertThat(book.getAgeLimit(), is(18));
        assertThat(book.getAuthorFirstName(), is("AuthorFirstName"));
        assertThat(book.getAuthorLastName(), is("AuthorLastName"));
    }
}
