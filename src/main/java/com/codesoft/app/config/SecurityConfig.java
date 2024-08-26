//package com.codesoft.app.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//public class SecurityConfig {
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().requestMatchers("/api/courses/**").hasRole("ADMIN")
//				.requestMatchers("/api/users/**").hasAnyRole("ADMIN", "STUDENT").anyRequest().authenticated().and()
//				.httpBasic(); // Enable Basic Authentication
//
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//		UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("admin123")).roles("ADMIN")
//				.build();
//
//		UserDetails student = User.withUsername("student").password(passwordEncoder.encode("student123"))
//				.roles("STUDENT").build();
//
//		return new InMemoryUserDetailsManager(admin, student);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}
