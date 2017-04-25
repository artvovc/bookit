package com.deusto.dtos;

import com.deusto.models.Book;

public class ReserveDTO {

    private long reserveDate;
    private long reserveExpire;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
