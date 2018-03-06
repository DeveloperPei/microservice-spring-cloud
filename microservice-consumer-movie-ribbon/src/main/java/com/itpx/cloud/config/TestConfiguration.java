package com.itpx.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.itpx.cloud.ExcludedFromComponentScan;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 自定义配置ribbon算法
 * @author Administrator
 * @ExcludedFromComponentScan   通过自定义注解，将该配置排除在@componentScan扫描之外 或者 将该类与启动类放在不同的包下否则会覆盖到所有的ribbon client
 */
@Configuration
@ExcludedFromComponentScan    
public class TestConfiguration {
	@Autowired
	IClientConfig config;
	
	@Bean   //配置ribbon负载均衡算法
	public IRule ribbonRule(IClientConfig config){
		return new RandomRule();
	}
}
