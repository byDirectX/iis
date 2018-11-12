package com.bondarev.iis;

import com.bondarev.iis.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class IIS {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] { IIS.class, JpaConfig.class }, args);
	}
}
