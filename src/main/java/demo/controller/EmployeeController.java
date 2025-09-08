package demo.controller;

import demo.entities.Employee;
import demo.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.add(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.getAll().remove(id);
    }
}