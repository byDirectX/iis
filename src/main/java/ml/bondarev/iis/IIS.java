package ml.bondarev.iis;

import ml.bondarev.iis.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IIS {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] { IIS.class, JpaConfig.class }, args);
	}
}
