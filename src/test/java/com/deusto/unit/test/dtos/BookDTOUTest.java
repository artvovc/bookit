package com.deusto.unit.test.dtos;

import com.deusto.dtos.BookDTO;
import com.deusto.unit.test.common.AbstractUT;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

public class BookDTOUTest extends AbstractUT {
    @Test
    public void validBookDTO() {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setAgeLimit(18);
        bookDTO.setAuthorFirstName("AuthorFirstName");
        bookDTO.setAuthorLastName("AuthorLastName");
        bookDTO.setCount(3);
        bookDTO.setDescription("Description");
        bookDTO.setGenre("Genre");
        bookDTO.setPages(401);
        bookDTO.setPublishDate(1492676887470L);
        bookDTO.setTags(Arrays.asList("tag1", "tag2"));
        bookDTO.setTitle("Title");

        assertThat(bookDTO.getAgeLimit(), is(18));

        assertTrue(validate(bookDTO).isEmpty());
    }
}
