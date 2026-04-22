package re.homework;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//Việc đưa các thông số như tên bệnh viện, hotline hay địa chỉ database vào file application.properties
// thay vì viết trực tiếp trong code Java mang lại nhiều lợi ích quan trọng.
//
//Trước hết, nó giúp tách biệt giữa cấu hình và logic xử lý. Khi các giá trị này thay đổi, lập trình viên
// chỉ cần chỉnh sửa trong file cấu hình mà không cần sửa code, từ đó giảm thiểu sai sót và tiết kiệm thời gian.
//
//Thứ hai, cách làm này giúp ứng dụng linh hoạt hơn khi triển khai ở nhiều môi trường khác nhau như development,
// testing hay production. Mỗi môi trường có thể sử dụng một bộ cấu hình riêng mà không cần thay đổi mã nguồn.
//
//Ngoài ra, việc quản lý tập trung các thông số trong file cấu hình giúp code trở nên dễ đọc, dễ bảo trì hơn,
// tránh tình trạng hard-code rải rác ở nhiều nơi trong hệ thống.
//
//Cuối cùng, đây cũng là một thực hành tốt trong phát triển phần mềm hiện đại, phù hợp với nguyên tắc cấu hình ngoài
// (external configuration) mà Spring Boot hướng tới.
@Component
public class HospitalConfig {
    @Value("${hospital.name}")
    private String name;

    @Value("${hospital.hotline}")
    private String hotline;


    public void init( ) {
        System.out.println("Hospital Name: " + this.name);
        System.out.println("Hotline: " + this.hotline);
    }
}
