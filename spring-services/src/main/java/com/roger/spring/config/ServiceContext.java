package com.roger.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.roger.spring.persistence.PersistenceJPAConfig;

@Configuration
@Import(PersistenceJPAConfig.class)
@ComponentScan(basePackages = "com.roger.spring.service")
public class ServiceContext {

}
