package re.edu.service;

import org.springframework.stereotype.Service;
import re.edu.dao.EmployeeDao;
import re.edu.model.Employee;

import java.util.List;
@Service
public class EmployeeService {
    private EmployeeDao employeeDao;
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }
}
