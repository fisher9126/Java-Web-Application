package re.homework.model.entity;



import jakarta.persistence.*;


@Entity
@Table(name = "medicines") // đúng quy định DB
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "unit", nullable = false)
    private String unit;

    // Constructor rỗng (bắt buộc cho Hibernate)
    public Medicine() {
    }

    public Medicine(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
//1. Vì sao Hibernate bắt buộc phải có @Id?
//
//Hibernate là ORM nên mỗi object (Entity) phải ánh xạ với một dòng duy nhất trong database.
//
// @Id chính là:
//
//Khóa chính (Primary Key) của bảng
//Dùng để:
//Phân biệt các bản ghi
//Quản lý trạng thái object (insert, update, delete)
//Cache và tracking entity
//
// Nếu không có @Id:
//
//Hibernate không biết record nào là duy nhất
//Không thể quản lý entity
//→ Báo lỗi: "No identifier specified for entity"
//2. Cách cấu hình tên bảng khác với tên class
//
//Mặc định:
//
//Class: Medicine
//→ Table: Medicine (giữ nguyên tên class)
//
// Nhưng yêu cầu:
//
//Table: medicines
//
//➡ Cách làm: dùng annotation
//
//@Table(name = "medicines")
//
// Ngoài ra:
//
//Có thể đổi tên cột bằng @Column(name = "...")