package com.deusto.builders;

import com.deusto.dtos.ReserveDTO;
import com.deusto.models.Reserve;
import com.deusto.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReserveBuilder {

    public static Reserve get(ReserveDTO reserveDTO) {
        Reserve reserve = new Reserve();
        reserve.setReserveDate(reserveDTO.getReserveDate());
        reserve.setReserveExpire(reserveDTO.getReserveExpire());
        reserve.setBook(reserveDTO.getBook());
        return reserve;
    }
}
