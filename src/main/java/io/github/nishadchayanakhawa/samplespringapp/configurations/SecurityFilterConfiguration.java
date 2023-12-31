package io.github.nishadchayanakhawa.samplespringapp.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import io.github.nishadchayanakhawa.samplespringapp.model.Role;

@Service
public class SecurityFilterConfiguration {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(request -> request
						.requestMatchers("/home").hasAnyRole(Role.ADMIN.toString(),Role.TESTER.toString(),Role.USER.toString())
						.requestMatchers("/login").permitAll()
						.requestMatchers("/bootstrap/**").permitAll()
						.requestMatchers("/images/**").permitAll()
						.requestMatchers("/fontawesome/**").permitAll()
						.anyRequest().authenticated())
				.formLogin(login -> 
						login.loginPage("/login").permitAll()
								.defaultSuccessUrl("/home",true)
								.failureUrl("/login?error=true"))
				.logout(logout->logout
						.logoutSuccessUrl("/login?logout=true")
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID"))
				.build();
	}
}
