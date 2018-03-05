package com.itpx.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itpx.cloud.entity.User;

@RestController
public class MovieController {
	@Autowired
	private RestTemplate restTemplate;
/*	@Value("${userUrl}")  
	private String userUrl;*/
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		//return restTemplate.getForObject("http://localhost:7900/simple/"+id, User.class);
		//vip virtual ip 虚拟ip  microservice-provider-user
		return restTemplate.getForObject("http://microservice-provider-user/simple/"+id, User.class);
		//return restTemplate.getForObject(userUrl+id, User.class);
	}
}