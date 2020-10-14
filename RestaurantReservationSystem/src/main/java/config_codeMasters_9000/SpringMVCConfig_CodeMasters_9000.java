package config_codeMasters_9000;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.csis3275") //This must match your packages
public class SpringMVCConfig_CodeMasters_9000 implements WebMvcConfigurer {

	 //View, this class resolves the view name to the .jsp file.
	 @Bean
	 public ViewResolver viewResolver() {
	 InternalResourceViewResolver viewResolver = new
	InternalResourceViewResolver();
	 viewResolver.setViewClass(JstlView.class);
	 viewResolver.setPrefix("/WEB-INF/views/");
	 viewResolver.setSuffix(".jsp");
	 return viewResolver;
	 }

	 //These are the messages we can pass back and forth between the controller model and view.
	 @Bean
	 public MessageSource messageSource() {
	 ResourceBundleMessageSource messageSource = new
	ResourceBundleMessageSource();
	 messageSource.setBasename("messages");
	 return messageSource;
	 }
	 //This is simply to allow any file requests past static to go through to the "/static" folder, we can add things like images css etc..
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {

	registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	 }
	}