package com.joseluisestevez.i18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringbootI18nDatabaseApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringbootI18nDatabaseApplication.class, args);
    }

}
