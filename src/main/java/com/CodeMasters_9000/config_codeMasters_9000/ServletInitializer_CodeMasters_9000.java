package com.CodeMasters_9000.config_codeMasters_9000;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import
org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletInitializer_CodeMasters_9000 implements WebApplicationInitializer {
	
	
	 public void onStartup(ServletContext container) throws ServletException {
	 AnnotationConfigWebApplicationContext ctx = new
	AnnotationConfigWebApplicationContext();
	 ctx.register(SpringMVCConfig_CodeMasters_9000.class);
	 ctx.setServletContext(container);
	 ServletRegistration.Dynamic servlet = container.addServlet(
	 "dispatcher", new DispatcherServlet(ctx));
	 servlet.setLoadOnStartup(1);
	 servlet.addMapping("/");
	 
	}

}
