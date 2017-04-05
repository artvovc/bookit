package com.deusto.builders;

import java.util.List;

import com.deusto.models.Book;

public class BookBuilder {
	
	Book book;
	
	public BookBuilder id(String id) {
		this.book.setId(id); 
		return this;
	}
	
	public BookBuilder title(String title) {
		this.book.setTitle(title);
		return this;
	}
	
	public BookBuilder authorFirstName(String authorFirstName) {
		this.book.setAuthorFirstName(authorFirstName);
		return this;
	}
	
	public BookBuilder authorLastName(String authorLastName) {
		this.book.setAuthorLastName(authorLastName);
		return this;
	}
	
	public BookBuilder genre(String genre) {
		this.book.setGenre(genre);
		return this;
	}
	
	public BookBuilder description(String description) {
		this.book.setDescription(description);
		return this;
	}
	
	public BookBuilder publishDate(Long publishDate) {
		this.book.setPublishDate(publishDate);
		return this;
	}
	
	public BookBuilder pages(int pages) {
		this.book.setPages(pages);
		return this;
	}
	
	public BookBuilder ageLimit(int ageLimit) {
		this.book.setAgeLimit(ageLimit);
		return this;
	}
	
	public BookBuilder count(int count) {
		this.book.setCount(count);
		return this;
	}
	
	public BookBuilder tags(List<String> tags) {
		this.book.setTags(tags);
		return this;
	}
	
	/* poti si sa faci constructor in builder care va primi toti parametri ... Da, pot */
	
	public Book Book(String id, String title, String authorFirstName, String authorLastName, String genre,
			String description, Long publishDate, int pages, int ageLimit, int count, List<String> tags) {
		this.book.setId(id);
		this.book.setAgeLimit(ageLimit);
		this.book.setTitle(title);
		this.book.setAuthorFirstName(authorFirstName);
		this.book.setAuthorLastName(authorLastName);
		this.book.setGenre(genre);
		this.book.setDescription(description);
		this.book.setPublishDate(publishDate);
		this.book.setPages(pages);
		this.book.setCount(count);
		this.book.setTags(tags);
		return this.book;
	}	
	
	/* Return finally constructed object */
	
	public Book build() {
		return this.book;
	}
}
