package re.manager.repository;



import org.springframework.stereotype.Repository;
import re.manager.model.entity.BookingRequest;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepository {

    private final List<BookingRequest> bookingList = new ArrayList<>();
    private Long idCounter = 1L;

    // ➕ thêm booking
    public void save(BookingRequest booking) {
        booking.setId(idCounter++);
        bookingList.add(booking);
    }

    // 📄 admin xem
    public List<BookingRequest> findAll() {
        return bookingList;
    }
}
