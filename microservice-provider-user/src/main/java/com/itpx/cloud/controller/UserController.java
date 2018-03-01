package com.itpx.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itpx.cloud.entity.User;
import com.itpx.cloud.reposity.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	@Autowired
	private EurekaClient discoveryClient;
	@Autowired
	private UserRepository userRepository;
	@GetMapping("/simple/{id}")//这个注解等价于 @RequestMapping(value="/simple/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable Long id){
		return userRepository.findOne(id);
	}
	
	@GetMapping("/eureka-instance")
	public String serviceUrl() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
	    return instance.getHomePageUrl();
	}
}
