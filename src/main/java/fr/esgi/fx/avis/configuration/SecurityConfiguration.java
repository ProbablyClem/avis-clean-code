package fr.esgi.fx.avis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

	private PasswordEncoder passwordEncoder;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// On peut se connecter sans utiliser https
	http.csrf(csrf -> csrf.disable());
	
	return http.build();
	}
	
	@Bean
	InMemoryUserDetailsManager initUtilisateurs() {
		UserDetails toto = User.builder().username("toto")
				.password(passwordEncoder.encode("toto"))
				.roles("ADMIN")
				.build();
		
		UserDetails titi = User.builder().username("titi")
				.password(passwordEncoder.encode("titi"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(toto, titi);
	}

}