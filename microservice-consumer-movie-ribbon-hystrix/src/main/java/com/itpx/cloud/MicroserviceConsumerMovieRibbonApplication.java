package com.itpx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableEurekaClient eureka客户端
 * 
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient("microservice-provider-user")//ribbon客户端  name 服务提供者ip 
@EnableCircuitBreaker
public class MicroserviceConsumerMovieRibbonApplication {
	@Bean
	@LoadBalanced //ribbon 里面的负载均衡 默认采用轮询
	public RestTemplate rs(){ 
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class, args);
	}
}