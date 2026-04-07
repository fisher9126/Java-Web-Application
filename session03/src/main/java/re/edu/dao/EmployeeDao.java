package re.edu.dao;

import org.springframework.stereotype.Repository;
import re.edu.model.Employee;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EmployeeDao {
    private List<Employee> employees;

    public EmployeeDao() {
        employees = new ArrayList<>();
        employees.add(new Employee(1,"Nguyễn Quang Huy","MAR", 15000));
        employees.add(new Employee(2,"Nguyễn Thế Kiên","Nhân sự", 10000));
        employees.add(new Employee(3,"Đỗ Trung Hiếu","Kế toán", 9000));
        employees.add(new Employee(4,"Trần An Ninh","MAR", 8000));
    }
    public List<Employee> getEmployees() {
        return employees;
    }
}
