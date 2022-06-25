package br.com.fattoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.fattoria"})
public class FattoriaBrunoLimaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FattoriaBrunoLimaApplication.class, args);
	}

}
