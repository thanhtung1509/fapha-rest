package com.netvn.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.FilterType;


@Configuration
//@ComponentScan("com.netvn.*")
@ComponentScan(basePackages={"com.netvn.*"},
excludeFilters=@ComponentScan.Filter(type=FilterType.REGEX, pattern={"com.netvn.web.*"}))
//@Import({ SecurityConfig.class, PersistenceConfig.class })
@PropertySource("classpath:application.properties")
public class WebAppConfig {
	
	
}
