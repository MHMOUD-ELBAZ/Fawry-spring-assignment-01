package demo.services;

import demo.entities.Employee;
import demo.exception.BadRequestException;
import demo.exception.NotFoundException;
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
        return employeeRepo.findById(id).orElseThrow(() -> new NotFoundException("no employee with id = " + id));
    }

    @Override
    public void add(Employee employee) {
        if(employee.getName() == null || employee.getName().trim().isEmpty())
            throw new BadRequestException("name can't be null");

        if(employeeRepo.findById(employee.getId()).isPresent())
            throw new BadRequestException("an employee exists with the same id");

        employeeRepo.add(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.getAll();
    }

    @Override
    public void delete(int id) {
        employeeRepo.delete(findById(id));
    }
}