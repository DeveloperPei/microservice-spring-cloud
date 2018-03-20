package com.itpx.cloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itpx.cloud.entity.User;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
	@RequestMapping(value="simple/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id); //两个注意点： 1 不支持 @GetMapping  2@PathVariable必选要写value值
	
	@RequestMapping(value="/simple/postTest",method=RequestMethod.POST)
	public User postUser(@RequestBody User user);
	
	@RequestMapping(value="/simple/getTest",method=RequestMethod.GET)
	public User getUser(@RequestBody User user);
}
