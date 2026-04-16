package re.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.manager.model.dto.BookingDTO;
import re.manager.model.entity.BookingRequest;
import re.manager.model.entity.Equipment;
import re.manager.repository.BookingRepository;
import re.manager.repository.EquipmentRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;
    public List<BookingRequest> findAll() {
       return bookingRepository.findAll();
    }
    public void create(BookingDTO dto) {

        Equipment eq = equipmentRepository.findById(dto.getEquipmentId());
        if ("LAB".equals(eq.getType())) {
            dto.setQuantity(1);
        }
        if (eq == null) {
            throw new RuntimeException("Thiết bị không tồn tại");
        }

        if (dto.getQuantity() > eq.getQuantity()) {
            throw new RuntimeException("Không đủ thiết bị");
        }

        if (dto.getReturnDate().isBefore(dto.getBorrowDate())) {
            throw new RuntimeException("Ngày trả phải sau ngày mượn");
        }


        BookingRequest b = new BookingRequest();
        b.setStudentName(dto.getStudentName());
        b.setStudentCode(dto.getStudentCode());
        b.setEmail(dto.getEmail());
        b.setQuantity(dto.getQuantity());
        b.setBorrowDate(dto.getBorrowDate());
        b.setReturnDate(dto.getReturnDate());
        b.setReason(dto.getReason());
        b.setEquipment(eq);

        // trừ kho
        eq.setQuantity(eq.getQuantity() - dto.getQuantity());

        bookingRepository.save(b);
    }
}