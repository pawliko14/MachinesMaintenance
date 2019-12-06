package net.codejava.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigApplicationContext appContext =  new AnnotationConfigApplicationContext();
		appContext.register(SpringMcvConfig.class);
	
		ServletRegistration.Dynamic dispachter = servletContext.addServlet("SpringDispatcher", new DispatcherServlet());
		dispachter.addMapping("/");
		
		
	}

}
