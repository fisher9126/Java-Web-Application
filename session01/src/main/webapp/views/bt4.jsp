

|Tiêu chí                          |Constructor Injection                          |Field Injection                         |
|----------------------------------|-----------------------------------------------|----------------------------------------|
|Tính bất biến (final)             |Hỗ trợ, dependency không đổi sau khi khởi tạo  |Không dùng được `final`                 |
|Đảm bảo đầy đủ dependency         |Bắt buộc phải có đủ để tạo object (an toàn hơn)|Có thể “quên” autowire, lỗi runtime     |
|Độ rõ ràng dependency             |Nhìn constructor thấy ngay class cần gì        |Dependency “ẩn” trong field             |
|Dễ Unit Test                      |Rất dễ (truyền mock qua constructor)           |Khó hơn, thường phải dùng Spring context|
|Phụ thuộc Spring (coupling với FW)|Ít hơn, có thể bỏ `@Autowired` từ Spring 4.3   |Nặng, class sống chết với Spring        |
5. Gắn với bối cảnh “mạng SMS đứt giữa chừng” ￼

Giả sử SMS service hay chập chờn, mình muốn:

- Dễ mock ‎`SmsSender` để test các case:

▫ Gửi email OK, SMS fail → log lỗi, retry, hoặc chỉ cảnh báo.

- Có thể thay implementation ‎`SmsSender` (ví dụ: từ Twilio sang một provider khác), mà không sửa ‎`NotificationService`.

Constructor Injection hỗ trợ điều này tốt hơn vì:

- Tách rõ hợp đồng: ‎`NotificationService` chỉ biết ‎`SmsSender` interface, không care implementation.

- Khi viết test:

▫ Mock ‎`SmsSender` để throw exception (mô phỏng mạng đứt).

▫ Kiểm tra ‎`NotificationService` xử lý như mong muốn (catch, log, fallback chỉ gửi email,…).

Field Injection làm được, nhưng:

- Test khó hơn (phải nạp context hoặc dùng reflection).

- Dependency khó nhìn, dễ bị “lạm dụng” field private mà gắn chặt với Spring.

