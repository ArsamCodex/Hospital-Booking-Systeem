package Hospital.System;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class HospitalBookingSysteemApplication {


	public static void main(String[] args) {
		SpringApplication.run(HospitalBookingSysteemApplication.class, args);











	}














//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	// Enable jdbc authentication
//	@Autowired
//	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());
//	}
}