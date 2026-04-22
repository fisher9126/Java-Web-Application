package re.homework.model.entity;



//Trong hệ thống quản lý đơn thuốc, thực thể Prescription (Đơn thuốc) có mối quan hệ một-nhiều với PrescriptionDetail
// (Chi tiết đơn thuốc). Điều này có nghĩa là một đơn thuốc sẽ chứa nhiều dòng chi tiết thuốc bên trong.
//
//Lỗi “TransientObjectException: object references an unsaved transient instance” xảy ra khi Hibernate phát hiện
// rằng đối tượng Prescription đang tham chiếu đến các đối tượng PrescriptionDetail chưa được lưu trong cơ sở dữ liệu.
// Nguyên nhân chính là do trong cấu hình quan hệ chưa thiết lập thuộc tính cascade, nên khi gọi lệnh lưu Prescription,
// Hibernate không tự động lưu các đối tượng chi tiết liên quan.
//
//Việc bổ sung CascadeType.ALL là cần thiết vì nó cho phép các thao tác trên thực thể cha (Prescription) được lan truyền
// xuống các thực thể con (PrescriptionDetail). Cụ thể, khi lưu đơn thuốc, tất cả các chi tiết sẽ được lưu tự động;
// khi xóa đơn thuốc, các chi tiết liên quan cũng sẽ bị xóa theo. Điều này hoàn toàn phù hợp với yêu cầu nghiệp vụ đã đặt ra.
//
//Ngoài ra, đối với danh sách chi tiết thuốc, nên sử dụng cơ chế tải dữ liệu trì hoãn (FetchType.LAZY). Lý do là vì
// trong nhiều trường hợp, khi truy vấn một đơn thuốc, hệ thống không cần thiết phải lấy toàn bộ danh sách chi tiết
// ngay lập tức. Nếu sử dụng FetchType.EAGER, Hibernate sẽ luôn tải toàn bộ dữ liệu chi tiết, gây tốn tài nguyên và
// làm giảm hiệu năng hệ thống. Ngược lại, LAZY chỉ tải dữ liệu khi thực sự cần sử dụng, giúp tối ưu hóa hiệu suất và
// giảm tải cho database.
//
//Tóm lại, việc thiếu CascadeType.ALL là nguyên nhân trực tiếp gây ra lỗi khi lưu dữ liệu, còn việc sử dụng FetchType.LAZY
// là một lựa chọn thiết kế hợp lý nhằm đảm bảo hiệu năng và khả năng mở rộng của hệ thống.
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quan hệ 1 - N
    @OneToMany(mappedBy = "prescription",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<PrescriptionDetail> details;

    public Prescription() {}

    public Long getId() {
        return id;
    }

    public List<PrescriptionDetail> getDetails() {
        return details;
    }

    public void setDetails(List<PrescriptionDetail> details) {
        this.details = details;
    }
}
