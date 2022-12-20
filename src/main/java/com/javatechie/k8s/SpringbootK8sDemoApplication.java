package com.javatechie.k8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SpringbootK8sDemoApplication {

	// @Bean
	// public CorsFilter corsFilter() {
	// 	CorsConfiguration corsConfiguration = new CorsConfiguration();
	// 	corsConfiguration.setAllowCredentials(true);
	// 	corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	// 	corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
	// 			"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
	// 			"Access-Control-Request-Method", "Access-Control-Request-Headers"));
	// 	corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
	// 			"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
	// 	corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	// 	UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
	// 	urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
	// 	return new CorsFilter(urlBasedCorsConfigurationSource);
	// }

// 	@Bean
// 	public CorsFilter corsFilter() {
//     final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//     final CorsConfiguration config = new CorsConfiguration();
//     config.setAllowCredentials(true);
//     config.addAllowedOrigin("*");
//     config.addAllowedHeader("*");
//     config.addAllowedMethod("OPTIONS");
//     config.addAllowedMethod("HEAD");
//     config.addAllowedMethod("GET");
//     config.addAllowedMethod("PUT");
//     config.addAllowedMethod("POST");
//     config.addAllowedMethod("DELETE");
//     config.addAllowedMethod("PATCH");
//     source.registerCorsConfiguration("/**", config);
//     return new CorsFilter(source);
// }
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedMethods("*").allowedOriginPatterns("*");
		}
	};
}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootK8sDemoApplication.class, args);
	}

}
