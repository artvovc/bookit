package com.deusto.repositories;

import com.deusto.models.Book;
import com.deusto.models.Reserve;
import com.deusto.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReserveRepository extends MongoRepository<Reserve, String> {

    Reserve insert(Reserve reserve);
    List<Reserve> findAllByBook(Book book);
    List<Reserve> findAllByUser(User user);
    List<Reserve> findAllByReserveDateBeforeAndReserveExpireAfter(Long before, Long after);
    List<Reserve> findDistinctByReserveDateAndReserveExpire(Long before, Long after);

    void delete(Reserve reserve);
}
