package com.deusto.dtos;

import com.deusto.models.Book;
import com.deusto.models.User;

public class ReserveDTO {

    private long reserveDate;
    private long reserveExpire;
    private User user;
    private Book book;

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
}
