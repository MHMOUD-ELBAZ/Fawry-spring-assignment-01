package demo.repositories;

import demo.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo {
    Optional<Employee> findById(int id);
    void add(Employee employee);
    List<Employee> getAll();
}
