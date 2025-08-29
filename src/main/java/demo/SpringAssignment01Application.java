package demo;

import demo.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAssignment01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAssignment01Application.class, args);
	}

    @Bean
    CommandLineRunner runner(EmployeeService service){
        return (args) -> {
            System.out.println(service.getAll());
        };
    }
}
