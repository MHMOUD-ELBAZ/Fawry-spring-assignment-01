package demo.services;

import demo.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(int id);
    void add(Employee employee);
    List<Employee> getAll();
}
