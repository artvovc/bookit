package com.deusto.dtos;

/**
 * Created by diana on 5/3/17.
 */
public class FilterDTO {

    private String title;
    protected String genre;
    // implement for author
    private long reserveDate;
    private long reserveExpire;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
