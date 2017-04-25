package com.deusto.services;

import com.deusto.models.Book;
import com.deusto.models.Reserve;
import com.deusto.models.User;
import com.deusto.repositories.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {

    @Autowired
    ReserveRepository reserveRepository;

    public Reserve insert(Reserve reserve) {
        return reserveRepository.insert(reserve);
    }

    public List<Reserve> findAllByBook(Book book) {
        return reserveRepository.findAllByBook(book);
    }

    public List<Reserve> findAllByUser(User user) {
        return reserveRepository.findAllByUser(user);
    }

    public List<Reserve> findAvailableBetweenDates(Long startingDate, Long  endindingDate) {
        return reserveRepository.findAllByReserveDateBeforeAndReserveExpireAfter(startingDate, endindingDate);
    }

    public Reserve update(Reserve reserve) {
        return reserveRepository.save(reserve);
    }
}
