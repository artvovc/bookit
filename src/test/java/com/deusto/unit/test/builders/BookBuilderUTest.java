package com.deusto.unit.test.builders;

import com.deusto.builders.BookBuilder;
import com.deusto.dtos.BookDTO;
import com.deusto.models.Book;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


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

    @Test
    public void validBookBuilderMethodStyle() {
        Book book = BookBuilder
                .builder()
                .authorFirstName("authorfirstname")
                .authorLastName("authorlastname")
                .ageLimit(18)
                .count(1)
                .description("Erotica")
                .genre("XXX")
                .pages(10)
                .publishDate(1L)
                .title("Sex poses")
                .tags(Arrays.asList("romance", "western", "forced", "hz"))
                .build();

        assertThat(book.getAuthorFirstName(), is("authorfirstname"));
        assertThat(book.getAuthorLastName(), is("authorlastname"));
        assertThat(book.getAgeLimit(), is(18));
        assertThat(book.getCount(), is(1));
        assertThat(book.getDescription(), is("Erotica"));
        assertThat(book.getGenre(), is("XXX"));
        assertThat(book.getPages(), is(10));
        assertThat(book.getPublishDate(), is(1L));
        assertThat(book.getTitle(), is("Sex poses"));
        assertThat(book.getTags(), is(Arrays.asList("romance", "western", "forced", "hz")));

        book = BookBuilder
                .builder()
                .description("pido-bear")
                .build();

        assertNull(book.getAuthorFirstName());
        assertNull(book.getAuthorLastName());
        assertNull(book.getAgeLimit());
        assertNull(book.getCount());
        assertThat(book.getDescription(), is("pido-bear"));
        assertNull(book.getGenre());
        assertNull(book.getPages());
        assertNull(book.getPublishDate());
        assertNull(book.getTitle());
        assertNull(book.getTags());
    }
}
