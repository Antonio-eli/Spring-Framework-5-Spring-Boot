package com.roancoder.springboot.di.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.roancoder.springboot.di.app.models.service.IServicio;
import com.roancoder.springboot.di.app.models.service.MiServicio;
import com.roancoder.springboot.di.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {

    @Bean("miServicioSimple")
    IServicio registarMiServicio() {
        return new MiServicio();
    }
    
    @Bean("miServicioComplejo")
    @Primary
    IServicio registarMiServicioComplejo() {
    	return new MiServicioComplejo();
    }

}
