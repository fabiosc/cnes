package br.com.desafio.cnes;

import java.io.IOException;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Classe responsavel por inicializar a aplicacao
 * @author Fabio Sicupira Cavalcante - sc.fabio@gmail.com
 */
@Configuration
@SpringBootApplication(scanBasePackages = {"br.com.desafio*"})
@EnableSpringDataWebSupport
public class CnesApplication {

	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(CnesApplication.class, args);
	}

}
