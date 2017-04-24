package com.deusto.builders;

import com.deusto.dtos.ReserveDTO;
import com.deusto.models.Reserve;

public class ReserveBuilder {

    public static Reserve get(ReserveDTO reserveDTO) {
        Reserve reserve = new Reserve();
        reserve.setReserveDate(reserveDTO.getReserveDate());
        reserve.setReserveExpire(reserveDTO.getReserveExpire());
        reserve.setUser(reserveDTO.getUser());
        reserve.setBook(reserve.getBook());
        return reserve;
    }
}
