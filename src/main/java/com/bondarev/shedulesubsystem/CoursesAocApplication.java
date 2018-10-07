package com.bondarev.shedulesubsystem;

import com.bondarev.shedulesubsystem.config.JpaConfig;
import com.bondarev.shedulesubsystem.config.WebMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bondarev.shedulesubsystem"})
public class CoursesAocApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] { CoursesAocApplication.class, JpaConfig.class, WebMvcConfig.class }, args);
	}
}
