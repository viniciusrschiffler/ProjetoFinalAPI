package org.serratec.backend.projetoFinal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigSeguranca implements WebMvcConfigurer{

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/*").allowedMethods("");
		}
}
