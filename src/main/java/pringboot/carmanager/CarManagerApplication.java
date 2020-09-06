package pringboot.carmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CarManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagerApplication.class, args);
	}

}
