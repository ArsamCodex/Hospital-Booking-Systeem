package Hospital.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
public class HospitalBookingSysteemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalBookingSysteemApplication.class, args);
	}

}
