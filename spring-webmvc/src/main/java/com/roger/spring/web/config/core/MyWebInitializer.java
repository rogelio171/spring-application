package com.roger.spring.web.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.roger.spring.config.ServiceContext;
import com.roger.spring.web.config.SpringWebContext;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {ServiceContext.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebContext.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
