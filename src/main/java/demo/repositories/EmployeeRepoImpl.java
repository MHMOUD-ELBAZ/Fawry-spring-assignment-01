package demo.repositories;

import demo.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepoImpl(){
        employees.addAll(
              List.of(
                      new Employee(1, "ahmed hany"),
                      new Employee(2, "tawfeeq el-hadidy"),
                      new Employee(3, "mohamed samir"),
                      new Employee(4, "omar ali")
              )
        );
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employees.stream().filter(emp -> emp.getId() == id).findFirst();
    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employees.stream().toList(); //immutable
    }

    @Override
    public void delete(Employee employee) {
        employees.remove(employee);
    }
}
