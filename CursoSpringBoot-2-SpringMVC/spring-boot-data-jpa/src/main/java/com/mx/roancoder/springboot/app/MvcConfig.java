package com.mx.roancoder.springboot.app;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mx.roancoder.springboot.app.controllers.ClienteController;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
		log.info("resourcePath ::" + resourcePath);
		registry.addResourceHandler("/uploads/**").addResourceLocations(resourcePath);
	}
	
}
