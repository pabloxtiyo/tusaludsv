/**
 * 
 */
package com.tusaludsv.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.tusaludsv.main.Application;


/**
 * @author xtiyo
 *
 */

@Configuration
public class ApplicationInitializer extends SpringBootServletInitializer implements WebApplicationInitializer  {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet
	 * .ServletContext)
	 */
	
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
	 {
	        return application.sources(Application.class);
	 }
	  
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		// Load application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationContext.class);
		rootContext.setDisplayName("Spring TM tigo");
		
		// Context loader listener
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		//Filter force encodig all aplication map
				FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
		        characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
		        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
		        characterEncodingFilter.setInitParameter("forceEncoding", "true");
		        
		// Dispatcher servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher_tm_tigo", new DispatcherServlet(
				rootContext));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		dispatcher.addMapping("*.css");
		dispatcher.addMapping("*.png");
		dispatcher.addMapping("*.ico");
		dispatcher.addMapping("*.js");
		dispatcher.addMapping("*.jrxml");

	
	}

	
	
}
