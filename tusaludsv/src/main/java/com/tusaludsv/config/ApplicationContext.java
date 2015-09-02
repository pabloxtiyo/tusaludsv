/**
 * 
 */
package com.tusaludsv.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author xtiyo
 *
 */

import nz.net.ultraq.web.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


/**
 * @author pablo portillo
 * @date 31/7/2014
 */

@Configuration
@ComponentScan(value ="com.ggd.tigo.*")
@EnableWebMvc
@EnableScheduling
public class ApplicationContext extends WebMvcConfigurerAdapter {
	
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").
        addResourceLocations("/WEB-INF/resources/");
    }
	
		
	@Bean
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
		resolver.setPrefix("/WEB-INF/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setOrder(1);
		return resolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());
		engine.addDialect(new LayoutDialect());
		return engine;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() 
	{
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		resolver.setContentType("text/html; charset=UTF-8");
		return resolver;
	}
	
	//Mail sender
	
//	@Bean
//    public JavaMailSenderImpl emailSender(){
//		
//        JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
//            emailSender.setHost(env.getRequiredProperty("email.host"));
//            emailSender.setPort(Integer.parseInt(env.getRequiredProperty("email.port")));
//            emailSender.setUsername(env.getRequiredProperty("email.username"));
//            emailSender.setPassword(env.getRequiredProperty("email.pass"));
//   
//            Properties mailProps = new Properties();
//                mailProps.setProperty("mail.transport.protocol","smtp");
//                mailProps.setProperty("mail.smtp.auth","true");
//                mailProps.setProperty("mail.smtp.starttls.enable","true");
//                mailProps.setProperty("mail.debug","true");
//                emailSender.setJavaMailProperties(mailProps);
//        return emailSender;
//    }

}
