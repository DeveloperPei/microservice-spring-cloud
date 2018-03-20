package com.itpx.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.itpx.cloud.entity.User;
import com.itpx.config.MyConfiguration;

import feign.Param;
import feign.RequestLine;

@FeignClient(name="microservice-provider-user", configuration=MyConfiguration.class)
public interface UserFeignClient {
	
	//@RequestMapping(value="simple/{id}",method=RequestMethod.GET)
	@RequestLine("GET /simple/{id}")  // feign 注解
	public User findById(@Param("id") Long id); 
}
