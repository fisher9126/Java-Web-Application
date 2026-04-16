package re.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.manager.model.entity.Equipment;
import re.manager.repository.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    //  lấy tất cả
    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    //  tìm theo id
    public Equipment getById(Long id) {
        return equipmentRepository.findById(id);
    }

    //  thêm
    public void add(Equipment e) {
        equipmentRepository.save(e);
    }

    // ️ sửa
    public void update(Equipment e) {
        equipmentRepository.update(e);
    }

    //  xóa
    public void delete(Long id) {
        equipmentRepository.delete(id);
    }
}
