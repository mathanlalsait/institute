package com.candid.sma.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.candid.sma.config.AppConfig;
/**
 * This class  is used in place of web.xml
 * @author Ankita
 *
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	//Redirecting to spring
	//Used in place of <servlet-mapping> tag in web.xml
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
}