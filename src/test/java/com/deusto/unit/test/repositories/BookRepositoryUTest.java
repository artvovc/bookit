package com.deusto.unit.test.repositories;

import com.deusto.unit.test.common.AbstractUT;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BookRepositoryUTest extends AbstractUT {

    @Test
    @UsingDataSet(locations = "/json/repositories/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findAllBooksTest() throws Exception {
        assertNotNull(bookRepository.findAll());
        assertThat(bookRepository.findAll().get(0).getTitle(), is("Test-book-1"));
    }

    @Test
    @UsingDataSet(locations = "/json/repositories/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findByTitleTest() throws Exception {
        assertThat(bookRepository.findByTitle("Test-book-1").get(0).getTitle(), is("Test-book-1"));
    }

    @Test
    @UsingDataSet(locations = "/json/repositories/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findAllByGenreTest() throws Exception {
        assertThat(bookRepository.findAllByGenre("genre1").get(0).getGenre(), is("genre1"));
    }

    @Test
    @UsingDataSet(locations = "/json/repositories/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findAllByAuthorLastNameTest() throws Exception {
        assertThat(bookRepository.findAllByAuthorLastName("authorLastName1").get(0).getAuthorLastName(), is("authorLastName1"));
    }

    @Test
    @UsingDataSet(locations = "/json/repositories/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findAllByAuthorFirstNameTest() throws Exception {
        assertThat(bookRepository.findAllByAuthorFirstName("authorFirstName1").get(0).getAuthorFirstName(), is("authorFirstName1"));
    }

    @Test
    @UsingDataSet(locations = "/json/repositories/book/actual.json", loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void findAllByIdTest() throws Exception {
        assertThat(bookRepository.findBookById("51b6eab8cd794eb62bb3e131").getId(), is("51b6eab8cd794eb62bb3e131"));
    }
}
