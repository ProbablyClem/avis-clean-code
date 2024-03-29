package fr.esgi.fx.avis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class AvisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvisApplication.class, args);
	}

	@Bean(name = "passwordEncoder")
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}