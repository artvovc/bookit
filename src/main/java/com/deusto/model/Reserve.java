package com.deusto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservers")
public class Reserve {
	@Id
	private String id;
	@DBRef 
	private User user;
	@DBRef 
	private Book book;
	private long reserveDate;
	private long reserveExpire;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public long getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(long reserveDate) {
		this.reserveDate = reserveDate;
	}
	public long getReserveExpire() {
		return reserveExpire;
	}
	public void setReserveExpire(long reserveExpire) {
		this.reserveExpire = reserveExpire;
	}
	

}
