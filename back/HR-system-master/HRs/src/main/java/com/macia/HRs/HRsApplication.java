package com.macia.HRs;

import com.macia.HRs.repository.EmployeeRepository;
import com.macia.HRs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HRsApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private EmployeeService empService;
	public static void main(String[] args) {
		SpringApplication.run(HRsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
