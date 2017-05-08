package com.deusto.dtos;

/**
 * Created by diana on 5/3/17.
 */
public class FilterDTO {

    private String title;
    protected String genre;
    // implement for author
    private Long reserveDate;
    private Long reserveExpire;

    public Long getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Long reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Long getReserveExpire() {
        return reserveExpire;
    }

    public void setReserveExpire(Long reserveExpire) {
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
