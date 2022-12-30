package com.roancoder.springboot.form.app.interceptors;

import java.util.Random;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TiempoTranscurridoInterceptor implements HandlerInterceptor{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		log.info("TiempoTranscurridoInterceptor {} :  preHandle() entrando");
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		Random random = new Random();
		Integer demora = random.nextInt(500);
		Thread.sleep(demora);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		long tiempoFin = System.currentTimeMillis();
		long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoTranscurrido = tiempoFin - tiempoInicio;
		
		if(modelAndView != null) {
			modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
		}
		log.info("Tiempo transcurrido: " + tiempoTranscurrido + " milisegundos");
		log.info("TiempoTranscurridoInterceptor {} :  postHandle() saliendo");
		
	
	}
	
}
