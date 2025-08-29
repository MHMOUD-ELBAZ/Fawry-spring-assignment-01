package demo.services;

import demo.entities.Employee;
import org.springframework.stereotype.Service;
import demo.repositories.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee findById(int id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("no employee with id = " + id));
    }

    @Override
    public void add(Employee employee) {
        if(employee.getName() == null || employee.getName().trim().isEmpty())
            throw new RuntimeException("name can't be null");

        if(employeeRepo.findById(employee.getId()).isPresent())
            throw new RuntimeException("an employee exists with the same id");

        employeeRepo.add(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.getAll();
    }
}
