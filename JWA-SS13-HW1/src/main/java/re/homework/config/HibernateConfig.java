package re.homework.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;
import javax.sql.DataSource;

@Configuration
public class HibernateConfig {

    @Bean

    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/ptit_javawebapplication_session13?createDatabaseIfNotExist=true");


        dataSource.setUsername("root");

        dataSource.setPassword("12345678");

        return dataSource;

    }


    @Bean
    public Properties properties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }



    @Bean

    public LocalSessionFactoryBean dataLocalSessionFactoryBean(Properties properties, DataSource dataSource) {

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        localSessionFactoryBean.setDataSource(dataSource);

        localSessionFactoryBean.setPackagesToScan("re.orm_hibernate.model");

        localSessionFactoryBean.setHibernateProperties(properties);

        return localSessionFactoryBean;

    }



}
//1. Vì sao thiếu hibernate.dialect thì Hibernate không khởi động được?
//
//hibernate.dialect dùng để chỉ ra loại hệ quản trị cơ sở dữ liệu (DBMS) mà Hibernate sẽ làm việc (MySQL, PostgreSQL, Oracle,...).
//
//Lý do bắt buộc phải có:
//
//Mỗi DB có cú pháp SQL khác nhau
//Ví dụ:
//MySQL: LIMIT 10
//PostgreSQL: LIMIT 10
//Oracle: dùng ROWNUM
//Hibernate cần dialect để:
//Sinh câu SQL phù hợp
//Mapping kiểu dữ liệu Java → DB
//Tối ưu truy vấn
//
// Nếu không có hibernate.dialect:
//
//Hibernate không biết phải generate SQL theo chuẩn nào
//Không thể tạo SessionFactory
//→ Ứng dụng fail khi startup
//2. Thuộc tính giúp tự động tạo bảng từ Java class
//
//Thuộc tính:
//
//hibernate.hbm2ddl.auto
//
// Các giá trị thường dùng:
//
//create: Xóa bảng cũ → tạo lại
//update: Cập nhật bảng (phổ biến nhất khi dev)
//create-drop: Tạo khi start, xóa khi stop
//validate: Kiểm tra schema, không tạo
//
// Ví dụ:
//
//Khi có class Medicine, Prescription
//→ Hibernate sẽ tự tạo bảng:
//medicines
//prescriptions