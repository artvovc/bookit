package com.deusto.builders;

import com.deusto.dtos.ReserveDTO;
import com.deusto.models.Reserve;

public class ReserveBuilder {

    /* Dapustim la mine in ReserveDTO ii numa bookID.
    Cand eu apelez metoda get()
    eu ii transmit ca parametru un obiect de tip ReserveDTO -
    care are numa fieldu bookID. Deci, ca sa setez
    reserve.setBook() -> eu trebuie sa fac cv gen bookRepository.getBookByID(id)
    nu-mi iese la socoteala
     */

//    public static Reserve get(ReserveDTO reserveDTO) {
//        Reserve reserve = new Reserve();
//        reserve.setBook(reserveDTO.getBookId());
//        return reserve;
//    }
}
