/**
 * 
 */
package com.itkweb.hday.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Enable Spring MVC features<br>
 * Component scan is only here for dispatcher servlet config
 * 
 * @author Vincent DAVY
 * 
 */
@Configuration
@EnableWebMvc
public class SpringMVCConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * Add here the list of static resources to be served without any modification
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*.html").addResourceLocations("/*.html").setCachePeriod(1);
		// registry.addResourceHandler("/*.js").addResourceLocations("/*.js").setCachePeriod(1);
		// registry.addResourceHandler("/stylesheet/*.css").addResourceLocations("/stylesheet/*.css").setCachePeriod(1);
		// registry.addResourceHandler("/app/src/*").addResourceLocations("/app/src/").setCachePeriod(1);
		// registry.addResourceHandler("/app/assets/img/*").addResourceLocations("/app/assets/img/").setCachePeriod(1);
	}

}
