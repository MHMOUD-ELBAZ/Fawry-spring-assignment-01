package demo.controller;

import demo.dtos.CustomerDto;
import demo.entities.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final List<Customer> customers = new ArrayList<>();
    private final AtomicInteger nextId = new AtomicInteger(1);

    @GetMapping
    public List<Customer> getAll(){
        return customers;
    }

    @PostMapping
    public Customer add(@RequestBody CustomerDto dto){
        Customer customer = new Customer(nextId.getAndIncrement(), dto.getName());
        customers.add(customer);
        return customer;
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Integer id){
        return customers.stream().
                filter(c -> c.getId().equals(id)).
                findFirst().orElseThrow(() -> new RuntimeException("no customer with id: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        var customer = customers.stream().
                filter(c -> c.getId().equals(id)).
                findFirst().orElseThrow(() -> new RuntimeException("no customer with id: " + id));

        customers.remove(customer);
        return ResponseEntity.ok().build();
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handle(RuntimeException ex){
        Map<String, Object> mp = new HashMap<>();
        mp.put("status code", 404);
        mp.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mp);
    }
}
