package com.deusto.services;

import com.deusto.dtos.ReserveDTO;
import com.deusto.models.Book;
import com.deusto.models.Reserve;
import com.deusto.models.User;
import com.deusto.repositories.BookRepository;
import com.deusto.repositories.ReserveRepository;
import com.deusto.repositories.UserRepository;
import com.deusto.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {

    @Autowired
    ReserveRepository reserveRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    public Reserve insert(ReserveDTO reserveDTO, SecurityUser securityUser) {
        Reserve reserve = new Reserve();
        reserve.setBook(bookRepository.findById(reserveDTO.getBookId()));
        reserve.setUser(userRepository.findByEmail(securityUser.getEmail()));
        return reserveRepository.insert(reserve);
    }

    public List<Reserve> findAll() {
        return reserveRepository.findAll();
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
