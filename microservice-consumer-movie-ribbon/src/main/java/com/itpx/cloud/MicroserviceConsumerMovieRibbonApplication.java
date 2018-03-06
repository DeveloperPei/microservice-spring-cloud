package com.itpx.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

import com.itpx.cloud.config.TestConfiguration;

/**
 * @EnableEurekaClient eureka客户端
 * 
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservice-provider-user", configuration = TestConfiguration.class)//ribbon客户端  name 服务提供者ip configuration 配置类  指定name的服务提供者采用该配置
@ComponentScan(excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION, value=ExcludedFromComponentScan.class)}) //扫描时将有注解ExcludedFromComponentScan的类排除在外
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