package com.CodeMasters_9000.config_codeMasters_9000;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@PropertySource("classpath:database.properties")
@EnableWebMvc
@ComponentScan(basePackages = "com.CodeMasters_9000.*")

public class SpringMVCConfig_CodeMasters_9000 extends WebMvcConfigurationSupport {

	
 @Bean
 public ViewResolver viewResolver() {
 InternalResourceViewResolver viewResolver = new
InternalResourceViewResolver();
 viewResolver.setViewClass(JstlView.class);
 viewResolver.setPrefix("/WEB-INF/views/");
 viewResolver.setSuffix(".jsp");
 return viewResolver;
 }

 @Bean
 public MessageSource messageSource() {
 ResourceBundleMessageSource messageSource = new
ResourceBundleMessageSource();
 messageSource.setBasename("messages");
 return messageSource;
 }

 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {

registry.addResourceHandler("/static/**").addResourceLocations("/static/");
 }
 
 @Autowired
 Environment environment;
 private final String URL = "url";
 private final String USER = "dbuser";
 private final String DRIVER = "driver";
 private final String PASSWORD = "dbpassword";
 @Bean
 DataSource dataSource() {
 DriverManagerDataSource driverManagerDataSource = new
 DriverManagerDataSource();
 driverManagerDataSource.setUrl(environment.getProperty(URL));
 driverManagerDataSource.setUsername(environment.getProperty(USER));
 driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
 driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
 return driverManagerDataSource;
 }
 
}

