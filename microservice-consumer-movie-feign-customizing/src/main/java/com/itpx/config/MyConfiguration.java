package com.itpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

@Configuration
public class MyConfiguration {
	@Bean
	public Contract feignContract() {
		return new feign.Contract.Default(); //默认契约 配置要求使用feign注解
	}
	@Bean 
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL; //打印所有日志
    }
}
