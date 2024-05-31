package com.srihari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@EnableWebMvc
@ComponentScan(basePackages="com.srihari")
public class Sample1Application {

	public static void main(String[] args) {
	SpringApplication.run(Sample1Application.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}
