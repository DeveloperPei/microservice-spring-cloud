package com.itpx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceConsumerMovieRibbonApplication {
	@Bean
	@LoadBalanced //ribbon 里面的负载均衡
	public RestTemplate rs(){ 
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class, args);
	}
}
