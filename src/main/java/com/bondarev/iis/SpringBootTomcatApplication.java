package com.bondarev.iis;

import com.bondarev.iis.config.JpaConfig;
import com.bondarev.iis.config.WebMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@ComponentScan(basePackages = {"com.bondarev.iis"})
public class SpringBootTomcatApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[] { IIS.class, JpaConfig.class, WebMvcConfig.class }, args);
    }
}
